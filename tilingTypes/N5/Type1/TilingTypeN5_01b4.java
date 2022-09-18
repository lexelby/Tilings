package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01b4
   extends TilingType
{
   public TilingTypeN5_01b4(){
      super( "N5-1b4", 6, SymmetryType.cm );
      // params are angle/distance of the other three points relative to first one
      paramMin = new int[]{  0,  0,-89};
      paramMax = new int[]{180,100, 89};
      paramDef = new int[]{ 60, 30, 20};
      paramName = new String[]{ "Angle", "Aspect", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,5, 0,3,4, 1},

            {0, 1,2, 0,0,1, 1},
            {1, 4,5, 2,3,4, 0},
      };
      info = "a=c\nd=e\nA+B=180\n(C+D+E=360)";
      labels = new int[]{0,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5*paramValues[1]/100.;
      double w = 1.5-h;
      double t = w*Math.tan( paramValues[2]* DEG2RAD)/2;
      double s = h*Math.sin( paramValues[0]* DEG2RAD);
      double c = h*Math.cos( paramValues[0]* DEG2RAD);
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, w/2,  0);
      baseTile.setPoint(2,   w,  0);
      baseTile.setPoint(3, w-c,  s);
      baseTile.setPoint(4,w/2-c,s+t);
      baseTile.setPoint(5,  -c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[1].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[1].getY(0);
   }
}
