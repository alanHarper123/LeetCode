package leetCode.problems._393_UTF_8_Validation;

public class Solution {
	static int validDataMesh;
	static int oneByteMesh;
	static int twoByteMesh;
	static int twoByteZeroMesh;
	static int threeByteMesh;
	static int threeByteZeroMesh;
	static int fourByteMesh;
	static int fourByteZeroMesh;
	static int carrierByteMesh;
	static int carrierByteZeroMesh;
	static {
		validDataMesh = 1;
		
		for (int i = 0; i < 7; i++) {
			validDataMesh<<=1;
			validDataMesh+=1;
		}
		oneByteMesh=1<<7;
		twoByteMesh=3;
		twoByteMesh<<=6;
		twoByteZeroMesh=7<<5;

		threeByteMesh = 7;
		threeByteMesh<<=5;
		
		threeByteZeroMesh=15<<4;

		fourByteMesh=15;
		fourByteMesh<<=4;

		fourByteZeroMesh=31<<3;
		
		carrierByteMesh = oneByteMesh;
		carrierByteZeroMesh =11<<6;

	}
    public boolean validUtf8(int[] data) {
        int i = 0;
        int validData = 0;
        int carriercount = 0;
        while (i<data.length) {
        	
        	carriercount = 0;
			validData = data[i]&validDataMesh;
			
			if((validData&oneByteMesh)==0) {
				
			}else if((validData&twoByteZeroMesh)==twoByteMesh) {
				carriercount = 1;
			}else if((validData&threeByteZeroMesh)==threeByteMesh) {
				carriercount = 2;
			}else if((validData&fourByteZeroMesh)==fourByteMesh) {
				carriercount = 3;
			}else {
				return false;
			}
			if(i+carriercount>=data.length)
				return false;
			for (int j = 0; j < carriercount; j++) {
				if(((data[++i]&validDataMesh)&carrierByteZeroMesh)!=carrierByteMesh)
					return false;
			}
            i++;
		}
        return true;
    }
}
