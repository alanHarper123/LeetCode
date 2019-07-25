package leetCode.problems._168_Excel_Sheet_Column_Title;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
	public String convertToTitle(int n) {
		LinkedList<Character> result = new LinkedList<>();
		int a = ((int)'A')-1;
		int re;
		while (n!=0) {
			re = n%26;
			if(re==0) {
				result.addFirst('Z');
				n/=26;
				n--;
			}				
			else {
				result.addFirst((char)(a+re));
				n/=26;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (Iterator<Character> iterator = 
				result.iterator(); iterator.hasNext();) {
			Character c = iterator.next();
			sb.append(c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int[] testData = {1,52,28,701};
		Solution solution = new Solution();
		for (int i = 0; i < testData.length; i++) {
			System.out.println(solution.convertToTitle(testData[i]));
		}
	}
}