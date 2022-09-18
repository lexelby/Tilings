package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_28b
   extends TilingType
{
   public TilingTypeN3_28b(){
      super( "N3-28b", 3, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,0,1, 0},
            {2, 2,1, 1,1,2, 0},
            {2, 1,0, 2,0,1, 0},
            {1, 1,2, 3,2,1, 0},
            {0, 0,1, 4,0,2, 0},

            {0, 2,1, 1,1,0, 1},
            {1, 0,2, 6,0,1, 1},
            {2, 2,1, 7,1,2, 1},
            {2, 1,0, 8,0,1, 1},
            {1, 1,2, 9,2,1, 1},
            {0, 0,1,10,0,2, 1},
      };
      info = "2a=b\nA=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,h+h,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[6].getX(1);
      offsets[1] = tiles[5].getY(2)-tiles[6].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[11].getX(1);
      offsets[3] = tiles[0].getY(2)-tiles[11].getY(1);
   }
}
