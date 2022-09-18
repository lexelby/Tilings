package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_21b
   extends TilingType
{
   public TilingTypeNC5_21b(){
      super( "NC5-21b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 50};
      paramName = new String[]{ "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 1,2, 2,1,2, 0},
      };
      info = "a=d\nB=90\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * paramValues[0]/100;   // base length
      double h = (1.5 - w)/2; // half height
      double d = (1-paramValues[1]/100.)*w/2; // offset

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,h+h);
      baseTile.setPoint(3,w-d,  h);
      baseTile.setPoint(4,  d,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(3);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(3);
   }
}
