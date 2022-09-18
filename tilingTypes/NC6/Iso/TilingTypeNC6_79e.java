package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_79e
   extends TilingType
{
   public TilingTypeNC6_79e(){
      super( "NC6-79e", 7, SymmetryType.cm );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,180,180};
      paramDef = new int[]{ 50, 70,100,130};
      paramName = new String[]{"Aspect", "Relative Length", "Angle 1", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,5, 0,3,4, 1},
      };
      info = "a=c\nb=e\nd=f\nA+B=180\nC+F=360\n(D+E=180)";
      labels = new int[]{0,1,2,3,-1,4,5};
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.4;
      double ln1 = lntotal * getParam(paramValues,0)/100;
      double ln23 = lntotal - ln1;
      double ln2 = ln23 * getParam(paramValues,1)/100;
      double ln3 = ln23 - ln2;
      double b = getParam(paramValues,2);
      double d = getParam(paramValues,3);

      double x5 = ln2 * Math.cos(b*DEG2RAD);
      double y5 = ln2 * Math.sin(b*DEG2RAD);
      double x4 = x5 + ln3 * Math.cos(d*DEG2RAD);
      double y4 = y5 + ln3 * Math.sin(d*DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1+x5, y5);
      baseTile.setPoint(3, ln1+x4, y4);
      baseTile.setPoint(4, ln1/2+x4, y4);
      baseTile.setPoint(5, x4, y4);
      baseTile.setPoint(6, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0);
   }
}