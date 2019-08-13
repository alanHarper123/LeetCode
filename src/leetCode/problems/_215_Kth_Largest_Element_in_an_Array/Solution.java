package leetCode.problems._215_Kth_Largest_Element_in_an_Array;

import java.util.Random;


public class Solution {
	private Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
    	k = nums.length - k;
    	return findKthLargestUtil(nums,
    			nums[random.nextInt(nums.length)], k, 0, nums.length-1);
    }
    private int findKthLargestUtil(int[] nums,int pivot,int k, int start, int end) {
    	int [] base= new int[3];
    	int temp;
    	boolean is1Set = false;
    	int si = start, ei = end;
    	while (si<=ei) {
    		if(nums[si]>pivot) {
    			temp = nums[si];
    			nums[si] = nums[ei];
    			nums[ei--] = temp;
    		}else if(nums[si]==pivot) {
    			base[1]++;
    			si++;
			}else {
				if(!is1Set) {
					base[2] = nums[si];
				}else {
					is1Set = !is1Set;
				}
				
				si++;
			}
		}
    	base[0] = si-1;
    	if(k>base[0]) {
    		return findKthLargestUtil(nums,
    				nums[base[0]+1+random.nextInt(end-base[0])], k, base[0]+1, end);
    	}else if(k<=base[0]-base[1]) {
    		return findKthLargestUtil(nums,base[2], k,start,base[0]);
    	}else {
    		return pivot;
    	}
    	
    }
    public static void main(String[] args) {
		int[][] testData1 = {
				{2,1},
				{3,2,1,5,6,4},
				{3,2,3,1,2,4,5,5,6},
		};
		int[] testData2 = {2,2,4};
		Solution solution = new Solution();
		for (int i = 0; i < testData2.length; i++) {
			System.out.println(solution.findKthLargest(testData1[i], testData2[i]));
		}
	}
}
