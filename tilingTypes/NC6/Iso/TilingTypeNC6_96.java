package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_96
   extends TilingType
{
   public TilingTypeNC6_96(){
      super( "NC6-96", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,100,100,100,100};
      paramDef = new int[]{ 60, 70, 70, 80, 20, 40};
      paramName = new String[]{ "Aspect", "Angle", "X", "Y", "Relative Length 1", "Relative Length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
      };
      info = "A+B=180\nD+E=360\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnb = lnt * getParam(paramValues,0)/100;
      double lnac = lnt-lnb;
      double lna = 2*lnac * getParam(paramValues,5)/100;
      double lnc = 2*lnac - lna;
      
      double a = getParam(paramValues,1);
      double c = Math.cos(a*DEG2RAD);
      double s = Math.sin(a*DEG2RAD);

      double x = getParam(paramValues,2)/100;
      double y = getParam(paramValues,3)/100;
      y *= (1-x)*lna + x*lnc;
      x *= lnb;
      double f = getParam(paramValues,4)/100;
      f = f / (1-f);
     
      double x5 = lna*c;
      double y5 = lna*s;
      double x2 = lnc*c+lnb;
      double y2 = lnc*s;
      double x3 = c*y + x;
      double y3 = s*y;
      double x4 = x5 + f * (x2-x3);
      double y4 = y5 + f * (y2-y3);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
      baseTile.setPoint(5,  x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(5)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(5)-tiles[0].getY(2);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(0);
   }
}