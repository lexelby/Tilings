package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_20b
   extends TilingType
{
   public TilingTypeNC5_20b(){
      super( "NC5-20b: Split squares", 5, SymmetryType.p4g );

      paramMin = new int[]{-135,  0};
      paramMax = new int[]{ 135,100};
      paramDef = new int[]{  30, 50};
      paramName = new String[]{ "Angle", "Relative length" };
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,3, 0,1,3, 0},
            {0, 0,3, 1,1,3, 0},
            {0, 0,3, 2,1,3, 0},

            {0, 0,1, 1,0,1, 1},
            {0, 0,3, 4,1,3, 1},
            {0, 0,3, 5,1,3, 1},
            {0, 0,3, 6,1,3, 1},
      };
      info = "a=c\nd=e\nC+E=360\nD=90\n(A+B=90)";
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];
      double ln = .5;
      double ln2 = ln * paramValues[1] / Math.cos((Math.abs(an)%90-45)*DEG2RAD) / 100;

      double x2 = ln + ln2 * Math.cos( (an- 45) * DEG2RAD);
      double y2 = ln + ln2 * Math.sin( (an- 45) * DEG2RAD);
      double x4 = ln + ln2 * Math.cos( (an-135) * DEG2RAD);
      double y4 = ln + ln2 * Math.sin( (an-135) * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,2*ln,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  ln, ln);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0);
   }
}
