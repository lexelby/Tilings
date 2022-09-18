package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_07
   extends TilingType
{
   public TilingTypeN3_07(){
      super( "N3-7", 3, SymmetryType.p4 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,2, 0,0,1, 0},
            {0, 0,2, 1,0,1, 0},
            {0, 0,2, 2,0,1, 0},

            {1, 1,2, 0,2,1, 0},
            {1, 1,2, 1,2,1, 0},
            {1, 1,2, 2,2,1, 0},
            {1, 1,2, 3,2,1, 0},
      };
      info = "b=2a\nA=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = 2*h;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[6].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[6].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[7].getY(0);
   }
}
