package leetCode.problems._Perform_String_Shifts;

public class Solution {
    public String stringShift(String s, int[][] shift) {
        int leftSC = 0;
        for (int i = 0; i < shift.length; i++) {
			if (shift[i][0]==0) {
				leftSC+=shift[i][1];
			}else {
				leftSC-=shift[i][1];
			}
		}
        int rightSC=0;
        int pivot;
        if(leftSC<0) {
        	rightSC = -leftSC;
        	rightSC%=s.length();
        	pivot = s.length()-rightSC;
        	
        }else if(leftSC>0) {
        	leftSC%=s.length();
        	pivot=leftSC;
        }else {
        	return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = pivot; i < s.length(); i++) {
			stringBuilder.append(s.charAt(i));
		}
    	for (int i = 0; i < pivot; i++) {
    		stringBuilder.append(s.charAt(i));
		}
    	return stringBuilder.toString();
    }
}
