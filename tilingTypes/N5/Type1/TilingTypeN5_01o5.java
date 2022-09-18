package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01o5
   extends TilingType
{
   public TilingTypeN5_01o5(){
      super( "N5-1o5", 6, SymmetryType.pgg );

      paramMin = new int[]{ 90,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{110, 50};
      paramName = new String[]{ "Angle", "Aspect"};
      // 0=ori, 1=scale=horiz width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,1,0, 1},
            {1, 2,4, 1,4,2, 1},
            {0, 1,0, 2,5,4, 0},

            {0, 2,3, 0,3,4, 1},
            {1, 5,4, 4,1,0, 0},
            {1, 2,4, 5,4,2, 0},
            {0, 1,0, 6,5,4, 1},
      };
      info = "b=2c=2e\nC+D=180\nA=E\n(A+B+E=360)";
      labels = new int[]{0,1,2,-1,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double c = Math.cos( paramValues[0] * DEG2RAD );
      double s = Math.sin( paramValues[0] * DEG2RAD );
      double ln1 = 1.2*getParam( paramValues,1)/100.; //vertical side
      double ln2 = 1.2-ln1;  // diagonal sides
      double ln3 = ln2/2;

      double x1 = ln2 * s;
      double y1 = ln2 * c;
      double x2 = x1 + ln3 * s;
      double y2 = y1 - ln3 * c;
      double x4 = 0;
      double y4 = ln1;
      double x3 = ln3 * s;
      double y3 = ln1 - ln3 * c;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, (x2+x3)/2, (y2+y3)/2);
      baseTile.setPoint(4, x3, y3);
      baseTile.setPoint(5, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(3);
   }
}
