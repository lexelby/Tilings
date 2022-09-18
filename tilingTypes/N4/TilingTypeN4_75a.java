package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_75a
   extends TilingType
{
   public TilingTypeN4_75a(){
      super( "N4-75a: Trisected equilateral triangles", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 80, 20};
      paramName = new String[]{ "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,1,2, 0},
            {2, 3,2, 1,1,2, 0},
            
            {1, 0,1, 2,0,3, 0},
            {2, 3,2, 3,1,2, 0},
            {0, 3,2, 4,1,2, 0},
            };
      info = "c=d\nA=60\nC=120\n(B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.75;
      double f = paramValues[0]/100.;
      double h = ln * Math.sqrt(3)/2;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, ln*f, 0);
      baseTile.setPoint(2, ln/2, h/3);
      baseTile.setPoint(3, ln*(1-f)/2, (1-f)*h );
   }

   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[1]/100.;
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0) + os*offsets[0];
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0) + os*offsets[1];
   }
}
