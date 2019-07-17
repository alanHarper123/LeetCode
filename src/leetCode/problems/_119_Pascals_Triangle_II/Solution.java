package leetCode.problems._119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> newE = new ArrayList<>(rowIndex+1);
        for (int i = 0; i <= rowIndex; i++) {
        	newE.add(1);
        	for (int j = newE.size()-2; j > 0 ; j--) {
				newE.set(j, newE.get(j)+newE.get(j-1));
			}
		}
        return newE;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getRow(3));
	}
}
