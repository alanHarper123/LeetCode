package leetCode.problems._650_2_Keys_Keyboard;

public class Solution {
	private Integer[] minStepsDp = new Integer[1001];
	public int minSteps(int n) {
		if(minStepsDp[n]==null) {
			if(n==1)
				return 0;
			int sqrtR = (int) Math.sqrt(n);

			for (int i = 2; i <= sqrtR; i++) {
				int count = 0;
				int sqrtI = (int) Math.sqrt(i);
				for (int j = 2; j <=sqrtI; j++) {
					if(i%j==0) {
						count++;
						break;
					}
				}
				if(count>0||n%i!=0)
					continue;
				else {
					int countI = 1;
					int nTemp = n;
					while (nTemp%i==0) {
						nTemp/=i;
						countI*=i;
					}
					int step;
					if(nTemp!=1) {
						step = minSteps(countI)+minSteps(nTemp);
					}else {
						step = i+minSteps(countI/i);
					}
					if(minStepsDp[n]==null||minStepsDp[n]>step)
						minStepsDp[n]=step;
				}
			}
			if(minStepsDp[n]==null)
				minStepsDp[n]=n;

		}
		return minStepsDp[n];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minSteps(6));
	}
}
