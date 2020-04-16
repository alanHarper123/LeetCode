package leetCode.problems._402_Remove_K_Digits;

import java.util.LinkedList;

public class Solution {
	// char '0' act as natural barriers, because it can be left undeleted.
	// all the other digits are separated into different clusters of digits.
	// if k is larger than any cluster of digits's indexes than all the 
	// cluster of digits should be deleted.

	public String removeKdigits(String num, int k) {
		int start = 0;
		int index_zero;
		while(true) {
			index_zero=num.indexOf('0', start);
			if(index_zero==-1||k<index_zero-start)
				break;
			else {
				k-=index_zero-start;
			}
			start = index_zero;
			while (start<num.length()&&num.charAt(start)=='0') {
				start++;
			}
		}
		if(start==num.length())
			return "0";
		if(k==0) {
			return num.substring(start);
		}
	
		if(index_zero==-1)
			index_zero = num.length();
		LinkedList<Character> chrs = new LinkedList<>();
		chrs.add(num.charAt(start));
		int deletedC = 0;
		int i = start+1;
		for (; deletedC<k&&i<index_zero; i++) {
			Character ref = chrs.peekLast();
			char c = num.charAt(i);
			while(!chrs.isEmpty()&&ref>c&&deletedC<k) {
				deletedC++;
				chrs.pollLast();
				ref = chrs.peekLast();
			}
			chrs.add(c);
		}
		i++;
		while (deletedC<k) {
			deletedC++;
			chrs.pollLast();
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		while(!chrs.isEmpty()) {
			stringBuilder.append(chrs.pollFirst());
		}
		stringBuilder.append(num.substring(i));
		if(stringBuilder.length()==0)
			stringBuilder.append(0);
		return stringBuilder.toString();
	}

}
