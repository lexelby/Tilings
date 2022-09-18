package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_01
   extends TilingType
{
   public TilingTypeP4_01(){
      super( "P4-1: Zipper pattern, offset", 5, SymmetryType.pg);

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 60, 66};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,0, 1},
            };
      labels = new int[]{0,1,2,3,-1};
      info = "b=c+d\nB+C=180\n2A+B=180\n(A+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double s = Math.sin( (paramValues[0]-90)* DEG2RAD);
      double c = Math.cos( (paramValues[0]-90)* DEG2RAD);
      double ln3 = .5/c * (paramValues[1]+1)/102.;  // short diagonal side
      double ln2 = 1/c - ln3;  // long diagonal side
      double ln4 = (ln3-ln2)*s*2; // length of vertical side

      baseTile.setPoint(0,     0, 0);
      baseTile.setPoint(1, ln2*c, -ln2 * s);
      baseTile.setPoint(2, ln3*c, ln4 - ln3*s);
      baseTile.setPoint(3,     0, ln4);
      baseTile.setPoint(4,     0, ln4/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
