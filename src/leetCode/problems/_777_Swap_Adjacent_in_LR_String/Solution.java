package leetCode.problems._777_Swap_Adjacent_in_LR_String;

public class Solution {
	public boolean canTransform(String start, String end) {
		int si = 0;
		int ei = 0;
		char[] startChars = start.toCharArray();
		char[] endChars = end.toCharArray();
		for (; si < startChars.length; si++) {
			if(startChars[si]=='L') {
				int eiTemp = ei;
				for (int j = ei;  j<= si; j++) {
					if(endChars[j]=='R')
						return false;
					else if(endChars[j]=='L') {
						ei = j+1;
						break;
					}
				}
				if(ei==eiTemp)
					return false;
			}else if(startChars[si]=='R') {
				for (int j = ei;  j< si; j++) {
					if(endChars[j]!='X')
						return false;
				}
				int eiTemp = ei;
				for (int i = Math.max(si, ei); i < end.length(); i++) {
					if(endChars[i]=='L')
						return false;
					else if(endChars[i]=='R') {
						ei = i+1;
						break;
					}	
				}
				if(eiTemp == ei)
					return false;
			}
			
		}
		for (int j = ei;  j< end.length(); j++) {
			if(endChars[j]!='X')
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canTransform("XXXXRXXXLX","XXXXRLXXXX"));
	}

}
