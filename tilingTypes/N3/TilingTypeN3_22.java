package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_22
   extends TilingType
{
   public TilingTypeN3_22(){
      super( "N3-22", 3, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 1,0, 1,0,1, 0},

            {0, 1,0, 1,2,0, 0},
            {1, 2,1, 3,1,2, 0},
            {2, 1,0, 4,0,1, 0},

            {0, 1,0, 4,2,0, 0},
            {1, 2,1, 6,1,2, 0},
            {2, 1,0, 7,0,1, 0},

            {0, 1,0, 7,2,0, 0},
            {1, 2,1, 9,1,2, 0},
            {2, 1,0,10,0,1, 0},

            {0, 1,0,10,2,0, 0},
            {1, 2,1,12,1,2, 0},
            {2, 1,0,13,0,1, 0},

            {0, 1,0,13,2,0, 0},
            {1, 2,1,15,1,2, 0},
            {2, 1,0,16,0,1, 0},
      };
      info = "b=3a\nA=120\n(B+C=60)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .2;
      double h = w*Math.sqrt( 3 );

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,6*w,  0);
      baseTile.setPoint(2, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[11].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[11].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[14].getX(1)-tiles[5].getX(2);
      offsets[3] = tiles[14].getY(1)-tiles[5].getY(2);
   }
}
