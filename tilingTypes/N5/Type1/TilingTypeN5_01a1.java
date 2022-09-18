package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01a1
	extends TilingType
{
	public TilingTypeN5_01a1(){
		super( "N5-1a1", 6, SymmetryType.p2 );
		// params are angle/distance of the other three points relative to first one
		paramMin = new int[]{  0,  0,  0,  0,  0,  0};
		paramMax = new int[]{180,100,180,100,100,100};
		paramDef = new int[]{ 70, 40,135, 45, 30, 10};
		paramName = new String[]{ "Angle", "Aspect", "Angle 2", "Relative Length", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,3, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 3,4, 2,4,3, 0},
            };
      info = "a=c\nA+B=180\n(C+D+E=360)";
      labels = new int[]{0,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*paramValues[1]/100.;
      double w = 2-ln2;
      double ln3 = ln2*getParam( paramValues,3)/100.;
      ln2 -= ln3;
      double x4 = -ln2 * Math.cos( paramValues[0] * DEG2RAD);
      double y4 = ln2 * Math.sin( paramValues[0] * DEG2RAD);
      double x3 = x4+w+ ln3 * Math.cos( (paramValues[0]+paramValues[2]) * DEG2RAD);
      double y3 = y4 - ln3 * Math.sin( (paramValues[0]+paramValues[2]) * DEG2RAD);
      double os = getParam(paramValues,5)/100.;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,os*w,  0);
      baseTile.setPoint(2,   w,  0);
      baseTile.setPoint(3,w+x4, y4);
      baseTile.setPoint(4,  x3, y3);
      baseTile.setPoint(5,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[4]/100.;
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[3].getX(0) + os * offsets[0];
      offsets[3] = tiles[1].getY(2)-tiles[3].getY(0) + os * offsets[1];
   }
}
