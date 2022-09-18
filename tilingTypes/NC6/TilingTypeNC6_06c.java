package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_06c
   extends TilingType
{
   public TilingTypeNC6_06c(){
      super( "NC6-6c", 6, SymmetryType.pmg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,1,2, 0},
            {0, 3,4, 0,4,3, 0},
            {1, 5,4, 2,1,2, 0},

            {1, 0,1, 3,0,1, 1},
            {0, 1,2, 4,5,4, 1},
            {0, 4,3, 5,3,4, 1},
            {1, 5,4, 6,1,2, 1},
      };
      info = "a=c=d=e=f\nA=72\nB=36\nD=108\nE=144\nF=144\n(C=216)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double c1 = ln * Math.cos(72 * DEG2RAD);
      double s1 = ln * Math.sin(72 * DEG2RAD);
      double c2 = ln * Math.cos(36 * DEG2RAD);
      double s2 = ln * Math.sin(36 * DEG2RAD);

      baseTile.setPoint(0,       0,       0);
      baseTile.setPoint(1,ln+2*c1+2*c2,   0);
      baseTile.setPoint(2,ln+2*c1+c2,    s2);
      baseTile.setPoint(3,ln+c1+c2,   s1+s2);
      baseTile.setPoint(4,   c1+c2,   s1+s2);
      baseTile.setPoint(5,      c1,      s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[7].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[7].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[1].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[1].getY(0);
   }
}