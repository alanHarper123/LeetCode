package leetCode.problems._525_Contiguous_Array;

public class Solution {
    public int findMaxLength(int[] nums) {
        int[] bitCounts = new int[nums.length+1];
        int bitCount = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==1)
				bitCount++;
			bitCounts[i+1]=bitCount;
		}
        int minDif = Integer.MAX_VALUE;
        int k=nums.length%2;
        while(k<nums.length) {
        	for (int i = 0; i <= k; i++) {
            	int dif = bitCounts[nums.length-k+i]-bitCounts[i]-(nums.length-k)/2;
            	if(dif==0)
            		return nums.length-k;
            	if(dif<0)
            		dif=-dif;
            	if(dif<minDif)
            		minDif=dif;
    		}
        	k+=minDif+minDif%2;
        }
        return 0;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test = new int[] {0,0,1,0,0,0,1,1};
		System.out.println(solution.findMaxLength(test));
	}
}
