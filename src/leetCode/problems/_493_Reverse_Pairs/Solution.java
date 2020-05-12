package leetCode.problems._493_Reverse_Pairs;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int reversePairs(int[] nums) {
    	int result = mergeSortAndCount(nums, 0, nums.length);
        return result;
    }
    private int mergeSortAndCount(int[] nums,int start,int end) {
    	if(end<=start+1)
    		return 0;
    	int mid = start+(end-start)/2;
    	int count = 0;
    	count += mergeSortAndCount(nums, start, mid);
    	count += mergeSortAndCount(nums, mid, end);
    	for (int i = start,j=mid; i < mid; i++) {
			while (j<end&&nums[i]>2L*nums[j]) {
				j++;
			}
			count+=j-mid;
		}
    	mergeSortAndCountUtil(Arrays.copyOfRange(nums, start, mid),
    			Arrays.copyOfRange(nums, mid, end), nums, start);
    	return count;
    }
    private void mergeSortAndCountUtil(int[] ns1,int[] ns2,int[] nums,int start) {
    	int ns1i = 0;
    	int ns2i = 0;
    	int i = start;
    	while (ns1i<ns1.length&&ns2i<ns2.length) {
			if(ns1[ns1i]>=ns2[ns2i]) {
				nums[i++]=ns2[ns2i++];
			}else 
				nums[i++]=ns1[ns1i++];
		}
    	while(ns1i<ns1.length) {
    		nums[i++]=ns1[ns1i++];
    	}
    	while(ns2i<ns2.length) {
    		nums[i++]=ns2[ns2i++];
    	}
    }
    public static void main(String[] args) {
    	int n = 40000;
		int[] test = new int[n];
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < test.length; i++) {
			test[i] = rand.nextInt();
		}
		Solution solution = new Solution();
		System.out.println(solution.reversePairs(test));
		for (int i = 1; i < test.length; i++) {
			if(test[i-1]>test[i])
				System.out.println("gg");
		}
	}
}
