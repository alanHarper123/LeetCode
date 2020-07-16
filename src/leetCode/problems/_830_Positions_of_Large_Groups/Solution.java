package leetCode.problems._830_Positions_of_Large_Groups;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        char C_cur;
        for (int i = 0; i < S.length(); i++) {
        	int iTemp = i;
        	C_cur = S.charAt(i);
			while (i+1<S.length()&&S.charAt(i+1)==C_cur) {
				i++;
			}
			if(i+1-iTemp>=3) {
				LinkedList<Integer> newE = new LinkedList<>();
				newE.add(iTemp);
				newE.add(i);
				res.add(newE);
			}
		}
        return res;
    }
}
