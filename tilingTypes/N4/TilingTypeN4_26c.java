package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_26c
   extends TilingType
{
   public TilingTypeN4_26c(){
      super( "N4-26c", 4, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{240};
      paramDef = new int[]{150};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {2, 1,2, 0,3,0, 1},

            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 3,0,1, 1},
            {2, 1,2, 3,3,0, 1},
      };
      info = "a=c=d\n2A+C=360\n(D=60)\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .65;
      double c = getParam( paramValues,0);
      double a = 180-c/2;
      double d = 90-(c-60)/2;
      double ln2 = 2 * ln1 * Math.cos(d*DEG2RAD);

      double x2 = ln2-ln1*Math.cos(d*DEG2RAD);
      double y2 =     ln1*Math.sin(d*DEG2RAD);
      double x3 = ln1*Math.cos(a*DEG2RAD);
      double y3 = ln1*Math.sin(a*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[2].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[2].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[4].getX(3);
      offsets[3] = tiles[1].getY(2)-tiles[4].getY(3);
   }
}
