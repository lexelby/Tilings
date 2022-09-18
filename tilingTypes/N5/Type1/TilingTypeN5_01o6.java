package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01o6
   extends TilingType
{
   public TilingTypeN5_01o6(){
      super( "N5-1o6", 5, SymmetryType.p2 );

      paramMin = new int[]{ 90,   0};
      paramMax = new int[]{180, 100};
      paramDef = new int[]{110,  60};
      paramName = new String[]{ "Angle", "Side split"};
      // 0=ori, 1=scale=horiz width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 0,4, 0,0,1, 0},
            {1, 2,3, 2,3,2, 0},
            };
      info = "a=b=c+e\nC+D=180\nA=E\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c = Math.cos( paramValues[0] * DEG2RAD );
      double s = Math.sin( paramValues[0] * DEG2RAD );
      double ln1 = .6;
      double ln3 = ln1*getParam( paramValues,1)/100.; //side split
      double ln4 = ln1-ln3;

      double x1 = ln1 * s;
      double y1 = ln1 * c;
      double x2 = x1 + ln3 * s;
      double y2 = y1 - ln3 * c;
      double x4 = 0;
      double y4 = ln1;
      double x3 = ln4 * s;
      double y3 = ln1 - ln4 * c;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(4);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(4);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(1);
   }
}
