package leetCode.problems._137_Single_Number_II;


public class Solution {
    public int singleNumber(int[] nums) {
// bit change to 0 after consecutive three 1 bit input
//		   a b   input a b
//    	   0 0	  0    0 0
//    	   0 1	  0    0 1
//    	   1 0	  0    1 0
//    	   0 0	  1    0 1
//    	   0 1	  1    1 0
//    	   1 0	  1    0 0
    	int a=0,b=0,input,temp;
    	for (int i = 0; i < nums.length; i++) {
    		input = nums[i];
			temp = (a&~b&~input)|(~a&b&input);
			b = (b&~a&~input)|(~b&~a&input);
			a = temp;
		}
    	return b;
    }
    public static void main(String[] args) {
		int[][] tests = {
				{2,2,3,2},
				{0,1,0,1,0,1,99},
				{4,4,4,2,2,2,109},
				
		};
		Solution solution = new Solution();
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.singleNumber(tests[i]));
		}
	}
}
