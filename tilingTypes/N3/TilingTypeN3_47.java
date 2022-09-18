package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_47
   extends TilingType
{
   public TilingTypeN3_47(){
      super( "N3-47", 4, SymmetryType.pgg );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 20};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {2, 0,3, 1,0,3, 1},
            {3, 3,2, 2,2,3, 1},
            {0, 3,0, 3,0,3, 1},
            {1, 3,2, 4,2,3, 1},
            {2, 0,3, 5,0,3, 0},
            {3, 3,2, 6,2,3, 0},

            {0, 1,0, 4,0,1, 1},
            {1, 3,2, 8,2,3, 1},
            {2, 0,3, 9,0,3, 0},
            {3, 3,2,10,2,3, 0},
            {0, 3,0,11,0,3, 0},
            {1, 3,2,12,2,3, 0},
            {2, 0,3,13,0,3, 1},
            {3, 3,2,14,2,3, 1},
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      double os = 2*ln1*getParam(paramValues,1)/100.;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,  os, 0);
      baseTile.setPoint(2, ln1, 0);
      baseTile.setPoint(3,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[12].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[12].getY(0)-tiles[0].getY(1);
   }
}