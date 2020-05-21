package leetCode.problems._537_Complex_Number_Multiplication;

public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] aPrs = parseStr(a);
        int[] bPrs = parseStr(b);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aPrs[0]*bPrs[0] - aPrs[1]*bPrs[1]);
        stringBuilder.append('+');
        stringBuilder.append(aPrs[0]*bPrs[1]+aPrs[1]*bPrs[0]);
        stringBuilder.append('i');
        return stringBuilder.toString();
    }
    private int[] parseStr(String str) {
    	int[] result = new int[2];
    	int plusIndex = str.indexOf('+');
    	result[0] = Integer.valueOf(str.substring(0, plusIndex));
    	result[1] = Integer.valueOf(str.substring(plusIndex+1,str.length()-1));
    	return result;
    }
}
