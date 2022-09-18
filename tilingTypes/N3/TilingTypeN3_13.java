package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_13
   extends TilingType
{
   public TilingTypeN3_13(){
      super( "N3-13", 5, SymmetryType.p2 );

      paramMin = new int[]{-100,  0,  0,  0};
      paramMax = new int[]{ 100,100,100,100};
      paramDef = new int[]{  10, 50, 40, 10};
      paramName = new String[]{ "Skew", "Aspect", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,4,0, 0},
            {0, 0,1, 1,1,0, 0},
            {1, 0,4, 2,4,0, 0},

            {1, 0,2, 0,2,0, 0},
            {0, 0,4, 4,4,0, 0},
            {0, 0,1, 5,1,0, 0},
            {1, 0,4, 6,4,0, 0},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5*(1+paramValues[1])/102.;
      double ln2 = 1.5-ln1;
      double dx = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os1 = ln1*getParam( paramValues,2)/100;
      double os2 = ln1*getParam( paramValues,3)/100;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,     os1,  0);
      baseTile.setPoint(2,     os2,  0);
      baseTile.setPoint(3,     ln1,  0);
      baseTile.setPoint(4,ln1/2+dx,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(0);
   }
}
