package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_57e
   extends TilingType
{
   public TilingTypeN4_57e(){
      super( "N4-57e", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Side ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,2, 0,2,4, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 1,0, 1,1,2, 0},

            {1, 2,3, 3,3,4, 1},
            {0, 1,2, 4,1,0, 1},
            {0, 4,2, 5,2,4, 1},
            {1, 1,0, 6,1,2, 1},
      };
      info = "b=a+c\nA=90\nB=90\n(C+D=180)";
      labels = new int[]{0,1,2,-1,3};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.25;
      double w = h;

      double h1 = h * getParam(paramValues,0)/100;
      double h2 = h - h1;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h1);
      baseTile.setPoint(3, w/2, h/2);
      baseTile.setPoint(4, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(2)-tiles[3].getX(4);
      offsets[1] = tiles[3].getY(2)-tiles[3].getY(4);
      offsets[2] = tiles[2].getX(2)-tiles[7].getX(3);
      offsets[3] = tiles[2].getY(2)-tiles[7].getY(3);
   }
}
