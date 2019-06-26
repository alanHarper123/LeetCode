package leetCode.problems.Remove_Duplicates_from_Sorted_Array_26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        if (nums.length>0) {
        	result++;
		}else {
			return result;
		}
        for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j]!=nums[i]) {
//					System.out.println(result+"  "+nums[result]+"   "+j+"  "+nums[j]);
					if(result!=j) {
						nums[result]=nums[j];
					}
					result++;
					i=j-1; break;
				}	
			}
		}
        return result;
    }
//    public static void main(String[] args) {
//		int [] test = {-3,-1,0,0,0,3,3};
//		Solution solution  = new Solution();
//		solution.removeDuplicates(test);
//	}
}
