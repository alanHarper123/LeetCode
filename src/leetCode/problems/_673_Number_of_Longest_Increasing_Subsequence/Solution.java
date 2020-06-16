package leetCode.problems._673_Number_of_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
        ArrayList<LinkedList<Integer>> smallEnds = new ArrayList<>();
        ArrayList<LinkedList<Integer>> counts = new ArrayList<>();
        for (int num:nums) {
			for (int i = 0;; i++) {
				if(i==smallEnds.size()||num<=smallEnds.get(i).peekFirst()) {
					LinkedList<Integer> smallEnd;
					LinkedList<Integer> count;
					if(i==smallEnds.size()) {
						smallEnd = new LinkedList<>();
						smallEnds.add(smallEnd);
						count = new LinkedList<>();
						counts.add(count);
					}else {
						smallEnd = smallEnds.get(i);
						count = counts.get(i);
					}
					smallEnd.addFirst(num);
					count.addFirst(countN(smallEnds, counts, i-1, num));
					break;
				}
			}
		}
        int NumberOfLIS = 0;
        LinkedList<Integer> lIS_counts = counts.get(counts.size()-1);
        for (int count:lIS_counts) {
			NumberOfLIS+=count;
		}
        return NumberOfLIS;
    }
    private int countN(ArrayList<LinkedList<Integer>> smallEnds,
    		ArrayList<LinkedList<Integer>> counts,int index,int target) {
    	if(index<0)
    		return 1;
    	Iterator<Integer> endsIter = smallEnds.get(index).listIterator(0);
    	Iterator<Integer> countsIter = counts.get(index).listIterator(0);
    	int count = 0;
    	while (endsIter.hasNext()) {
			int end = endsIter.next();
			if(target>end) {
				count+=countsIter.next();
			}else {
				break;
			}
		}
    	return count;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println(solution.findNumberOfLIS(new int[] {1,3,5,4,7}));
	}
}
