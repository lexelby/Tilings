package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_29g
   extends TilingType
{
   public TilingTypeN4_29g(){
      super( "N4-29g", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 58};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {2, 1,0, 0,2,3, 0},
            {1, 1,0, 1,2,3, 0},

            {0, 0,1, 0,0,1, 1},
            {0, 1,0, 0,1,2, 0},

            {1, 1,0, 4,3,2, 1},
            {2, 1,0, 5,2,3, 1},
            {1, 1,0, 6,2,3, 1},
            
            {0, 0,1, 7,2,3, 0},
            {0, 1,0, 7,3,0, 1},
      };
      info = "a=c\nb=d\nA=60\nB=120\nC=60\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
      double h = w*Math.sqrt(3);
      double f = 2*getParam(paramValues,0)/100.;
      double g = 2-f;
    
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,f*h,-f*w);
      baseTile.setPoint(2,h+h,(g-f)*w);
      baseTile.setPoint(3,g*h, g*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(3)-tiles[9].getX(3);
      offsets[3] = tiles[2].getY(3)-tiles[9].getY(3);
   }
}