package leetCode.problems._659_Split_Array_into_Consecutive_Subsequences;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Solution {
    public boolean isPossible(int[] nums) {
        if(nums==null||nums.length<3)
        	return false;
        return isPossibleUtil(nums, 0);
    }
    private boolean isPossibleUtil(int[] nums,int start) {
    	LinkedList<Integer> heads = new LinkedList<>();
    	LinkedList<Integer> counts = new LinkedList<>();
    	Integer pre = null;
    	int preCount = 0;
    	for (int i = start; i < nums.length;) {
			int cur = nums[i];
			int count = 0;
			do {
 				i++;
				count++;
			} while (i < nums.length&&nums[i]==cur);
			if(pre==null) {
				heads.add(cur);
				counts.add(count);
			}else if(cur-pre==1) {
				if(count-preCount>0) {
					heads.add(cur);
					counts.add(count-preCount);
				}else if(count-preCount<0) {
					if(!settleDif(heads, counts, preCount-count, cur))
						return false;
				}
			}else {
				if(!settleDif(heads, counts, preCount, pre+1))
					return false;
				return isPossibleUtil(nums, i);
			}
			pre = cur;
			preCount = count;
		}
    	if(!heads.isEmpty()&&!settleDif(heads, counts, preCount, pre+1)) {
    		return false;
    	}
    	return true;
    }
    private boolean settleDif(LinkedList<Integer> heads,LinkedList<Integer> counts,int dif,int cur) {
    	while (dif>0) {
			if(heads.isEmpty()||cur-heads.peekFirst()<3) {
				return false;
			}
			if(dif-counts.peekFirst()<0) {
				counts.set(0, counts.peekFirst()-dif);
				dif=0;
			}else {
				dif-=counts.pollFirst();
				heads.pollFirst();
			}
		}
    	return true;
    }
    public static void main(String[] args) {
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new java.io.File("C:\\Users\\alan\\Desktop\\gg.txt")));
			String data = bf.readLine();
			data = data.substring(1, data.length()-1);
			String[] nums = data.split(",");
			int[] ggTestData = new int[nums.length];
			for (int i = 0; i < ggTestData.length; i++) {
				ggTestData[i] = Integer.valueOf(nums[i]);
			}
			Solution solution = new Solution();
			System.out.println(solution.isPossible(ggTestData));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
