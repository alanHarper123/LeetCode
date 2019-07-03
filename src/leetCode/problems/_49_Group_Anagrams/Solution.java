package leetCode.problems._49_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<Integer, List<Integer>> indexLists = new HashMap<>();
		ArrayList<List<String>> resultLists = new ArrayList<>(strs.length);
		loop1: for (int i = 0; i < strs.length; i++) {
			List<Integer> indexList = indexLists.get(strs[i].length());
			if (indexList!=null) {
				loop2: for (Iterator<Integer> iterator = indexList.iterator(); iterator.hasNext();) {
					Integer j = iterator.next();
					boolean[] used = new boolean[strs[i].length()];
					for (int k = 0; k < strs[i].length(); k++) {
						int l;
						for (l = 0; l < used.length; l++) {
							if((!used[l])&&strs[i].charAt(k)==resultLists.get(j).iterator().next().charAt(l)) {
								used[l]=true;
								break;
							}
						}
						if(l==used.length)
							continue loop2;
						
					}
					for (int k = 0; k < used.length; k++) {
						if(used[k]==false) {
							continue loop2;
						}
					}
					resultLists.get(j).add(strs[i]);
					continue loop1;
				}
			}
			LinkedList<String> newList = new LinkedList<>();
			
			newList.add(strs[i]);
			resultLists.add(newList);
			if(indexList!=null) {
				indexList.add(resultLists.size()-1);
			}else {
				List<Integer> newindexList = new LinkedList<>();
				newindexList.add(resultLists.size()-1);
				indexList = newindexList;
			}
			indexLists.put(strs[i].length(), indexList);

		}
		return resultLists;
	}
	public static void main(String[] args) {
		String[] testStrings = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(new Solution().groupAnagrams(testStrings));
	}
}
