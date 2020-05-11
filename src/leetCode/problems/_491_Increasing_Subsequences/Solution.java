package leetCode.problems._491_Increasing_Subsequences;

import java.util.LinkedList;
import java.util.List;


class doubleLinkList {
	int val;
	doubleLinkList next;
	LinkedList<LinkedList<Integer>> loads;
	public doubleLinkList(int val,LinkedList<LinkedList<Integer>> loads,doubleLinkList next) {
		this.loads = loads;
		this.next = next;
		this.val = val;
	}
}


public class Solution {
	public List<List<Integer>> findSubsequences(int[] nums) {
		LinkedList<List<Integer>> summary = new LinkedList<>();
		if(nums==null||nums.length<=1)
			return summary;
		doubleLinkList head = null;
		doubleLinkList runner;
		for (int i = 0; i < nums.length; i++) {
			LinkedList<Integer> headload = new LinkedList<>();
			headload.add(nums[i]);
			LinkedList<LinkedList<Integer>> summaryi = new LinkedList<>();
			summaryi.add(headload);
			runner = head;
			doubleLinkList pre = null;
			while (true) {
				if(runner==null||nums[i]<runner.val) {
					doubleLinkList newNode = new doubleLinkList(nums[i], summaryi, runner);
					if(pre!=null) {
						pre.next = newNode;
					}else {
						head = newNode;
					}
					break;
				}else {
					for (LinkedList<Integer> list:runner.loads) {
						if(nums[i]==runner.val&&list.peekLast()!=nums[i]) {
							continue;
						}
						LinkedList<Integer> newList = new LinkedList<>();
						for (Integer ier : list) {
							newList.add(ier);
						}
						newList.add(nums[i]);
						summaryi.add(newList);
					}
					if(nums[i]==runner.val) {
						doubleLinkList newNode = new doubleLinkList(nums[i], summaryi, runner.next);
						if(pre!=null) {
							pre.next = newNode;
						}else {
							head = newNode;
						}
						break;
					}
					pre = runner;
					runner = runner.next;
				}
			}
		}
		runner = head;
		while (runner!=null) {
			for (List<Integer> list:runner.loads) {
				if(list.size()!=1)
					summary.add(list);
			}
			runner = runner.next;
		}


		return summary;
	}
}
