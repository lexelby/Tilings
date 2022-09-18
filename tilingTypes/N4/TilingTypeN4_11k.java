package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_11k
   extends TilingType
{
   public TilingTypeN4_11k(){
      super( "N4-11k", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {2, 2,1, 1,1,2, 1},
            {2, 3,2, 2,2,3, 1},
            {1, 2,1, 3,1,2, 1},
            {0, 1,2, 4,2,3, 0},

            {0, 3,0, 0,2,3, 1},
            {1, 2,3, 6,1,2, 0},
            {2, 2,1, 7,1,2, 0},
            {2, 3,2, 8,2,3, 0},
            {1, 2,1, 9,1,2, 0},
            {0, 1,2,10,2,3, 1},
      };
      info = "a=c=d\n2B+C=360\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double f = getParam( paramValues,0)/100.;
      double g = 1-f;
      double ln = Math.sqrt(f*f+g*g);
      double h = f/ln;
      double ln2 = g/ln;
      double ln3 = Math.sqrt( 3+ln2*ln2 )/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln2,  0);
      baseTile.setPoint(2,ln2 + ln3, h/2);
      baseTile.setPoint(3,ln2,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(3)-tiles[11].getX(2);
      offsets[3] = tiles[5].getY(3)-tiles[11].getY(2);
   }
}
