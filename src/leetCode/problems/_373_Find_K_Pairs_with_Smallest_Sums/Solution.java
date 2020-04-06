package leetCode.problems._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


class Pair{
	static int[] nums2;
	final int nums1i;
	int j=0;
	int pairsum;
	public Pair(int[] nums1,int i) {
		this.nums1i=nums1[i];
		pairsum = nums1i+nums2[j];
	}
	public boolean next() {
		j++;
		if(j<nums2.length)
			pairsum = nums1i+nums2[j];
		return j<nums2.length;
	}
	
}
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	
    	LinkedList<List<Integer>> result = new LinkedList<>();
    	if(nums1==null||nums2==null)
    		return result;
    	boolean isReverse = false;
    	if(nums2.length<nums1.length) {
    		isReverse = true;
    		int[] temp = nums1;
    		nums1 = nums2;
    		nums2 = temp;
    	}
    	Pair.nums2 = nums2;
    	PriorityQueue<Pair> basePairs = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1,
					Pair p2) {
				return p1.pairsum-p2.pairsum;}
			});
        for (int i = 0; i < nums1.length; i++) {
			basePairs.add(new Pair(nums1, i));
		}
        for (int i = 0; i < k&&!basePairs.isEmpty(); i++) {
			Pair p = basePairs.poll();
			List<Integer> newL = new LinkedList<>();
			if(isReverse) {
				newL.add(nums2[p.j]);
				newL.add(p.nums1i);
			}else {
				newL.add(p.nums1i);
				newL.add(nums2[p.j]);
			}
			if(p.next())
				basePairs.add(p);
			result.add(newL);
		}
        return result;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		solution.kSmallestPairs(null, null, 5);
	}
}
