package leetCode.problems._944_Delete_Columns_to_Make_Sorted;

import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
	public int minDeletionSize(String[] A) {
		if(A.length==1)
			return 0;
		char[] chars = A[0].toCharArray();
		LinkedList<Integer> validIndex = new LinkedList<>();
		for (int i = 0; i < chars.length; i++) {
			validIndex.add(i);
		}
		int index;
		for (int i = 1; i < A.length; i++) {
			if(validIndex.size()==0)
				return chars.length;
			ListIterator<Integer> iter = validIndex.listIterator();
			while (iter.hasNext()) {
				index = iter.next();
				if(chars[index]<=A[i].charAt(index)) {
					chars[index]=A[i].charAt(index);
				}else {
					iter.remove();
				}
			}
		}
		return chars.length - validIndex.size();
	}
	public static void main(String[] args) {
		System.out.println(new Solution().minDeletionSize(new String[] {"a","b"}));
	}
}
