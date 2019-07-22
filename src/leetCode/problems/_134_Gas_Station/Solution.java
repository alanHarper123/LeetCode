package leetCode.problems._134_Gas_Station;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int potentialStartPoint = -1;
        int remainingGasForStartPoint = 0;
        int remainingGas = 0;
        for (int i = 0; i < gas.length; i++) {
        	remainingGas += gas[i]-cost[i];
			if(gas[i]>0&&potentialStartPoint==-1)
				potentialStartPoint = i;
			remainingGasForStartPoint = 
					remainingGasForStartPoint+gas[i]-cost[i];
			if(remainingGasForStartPoint<0) {
				potentialStartPoint=-1;
				remainingGasForStartPoint=0;
			}	
		}
        if (remainingGas<0) {
			return -1;
		}else {
			return potentialStartPoint;
		}
    }
    public static void main(String[] args) {
		int[][][] tests = {
				{{1,2,3,4,5},
				{3,4,5,1,2},},
				{{2,3,4},{3,4,3}},
		};
		Solution solution = new Solution();
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.canCompleteCircuit(tests[i][0], tests[i][1]));
		}
	}
}
