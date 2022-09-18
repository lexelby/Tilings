package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_15b
   extends TilingType
{
   public TilingTypeNC6_15b(){
      super( "NC6-15b", 6, SymmetryType.pgg );

      paramMin = new int[]{ 30};
      paramMax = new int[]{150};
      paramDef = new int[]{110};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,5, 1,2,3, 0},
            {0, 0,1, 2,0,1, 1},

            {0, 4,3, 0,3,4, 0},
            {1, 0,1, 4,0,1, 1},
            {1, 4,5, 5,2,3, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=c=d=e=f\nA=B\nD+F=360\n2A+F=360\n(C+E=F)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0);
      
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      double c2 = ln * Math.cos( (a-60) * DEG2RAD );
      double s2 = ln * Math.sin( (a-60) * DEG2RAD );
      double ln2 = (s+s)*Math.sqrt(3)/2 + c;

      baseTile.setPoint(0,     0,     0);
      baseTile.setPoint(1,   ln2,     0);
      baseTile.setPoint(2, ln2-c,     s);
      baseTile.setPoint(3,    c2,s+s-s2);
      baseTile.setPoint(4,     0,   s+s);
      baseTile.setPoint(5,     c,     s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[7].getX(4);
      offsets[1] = tiles[3].getY(3)-tiles[7].getY(4);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(5);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(5);
   }
}