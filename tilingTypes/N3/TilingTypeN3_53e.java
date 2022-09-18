package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_53e
   extends TilingType
{
   public TilingTypeN3_53e(){
      super( "N3-53e", 4, SymmetryType.pgg );
      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {1, 1,3, 1,1,3, 0},
            {1, 0,1, 2,1,0, 0},
            {0, 1,3, 3,1,3, 1},
            {2, 0,1, 4,0,1, 0},

            {2, 3,2, 0,2,1, 1},
            {0, 0,1, 6,0,1, 0},
            {1, 1,3, 7,1,3, 1},
            {1, 0,1, 8,1,0, 1},
            {0, 1,3, 9,1,3, 0},
            {2, 0,1,10,0,1, 1},
      };
      info = "A=90\nB=30\n(C=60)";
      labels = new int[]{0,1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w*3/4,  h/4);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(3);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(3);
      offsets[2] = tiles[5].getX(3)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(3)-tiles[11].getY(2);
   }
}
