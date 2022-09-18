package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_33b
   extends TilingType
{
   public TilingTypeNC5_33b(){
      super( "NC5-33b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 2,0, 2,0,2, 0},
      };
      info = "a=d\nb=c+e\nB=90\nD+E=360\nC+D=180\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double ln2 = ln*(1 + .5 * paramValues[0] / 100);
      double ln3 = 3*ln-ln2;
      double ln4 = ln3-ln2;
      double ln2b = ln2-ln4;
      double ln1 = Math.sqrt(ln2b*ln2b+ln3*ln3)/2;
      double b = Math.atan2(ln2b,ln3)/DEG2RAD;

      double d = b+90;
      double e = 180-d;
      double c = 360-d;

      double x4 =      ln1 * Math.cos( b * DEG2RAD);
      double y4 =      ln1 * Math.sin( b * DEG2RAD);
      double x3 = x4 + ln4 * Math.cos( (b-180+c) * DEG2RAD);
      double y3 = y4 + ln4 * Math.sin( (b-180+c) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = x2 + ln2 * Math.cos( (b-180+e) * DEG2RAD);
      double y1 = y2 + ln2 * Math.sin( (b-180+e) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(4);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(4);
   }
}
