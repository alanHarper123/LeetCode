package leetCode.problems._788_Rotated_Digits;

public class Solution {
    public int rotatedDigits(int N) {
    	int count = 0;
    	boolean isGood = false;
        loop1 : for (int i = 1; i <= N; i++) {
			char[] chars = String.valueOf(i).toCharArray();
			isGood = false;
			for (int j = chars.length-1; j >=0 ; j--) {
				char c = chars[j];
				if(c=='2'||c=='5'||c=='6'||c=='9')
					isGood = true;
				else if(!(c=='0'||c=='1'||c=='8'))
					continue loop1;
			}
			if(isGood)
				count++;
		}
    	return count;
    }
    static char[] validR = new char[] {'0','1','2','5','6','8','9'};
    public int rotatedDigits002(int N) {
    	return validCombination(String.valueOf(N).toCharArray(), 0, false, true);
    }
    private int validCombination(char[] original, int i, boolean isGood,boolean onEdge) {
    	if(i==original.length)
    		return isGood?1:0;
    	int sum = 0;
    	boolean isGoodTemp = isGood;
    	boolean onEdgeTemp = onEdge;
    	for (int j = 0; j < validR.length; j++) {
    		isGood = isGoodTemp;
    		onEdge = onEdgeTemp;
    		if(onEdge&&validR[j]>original[i])
    			return sum;
    		if(validR[j]<original[i])
    			onEdge = false;
			if(!isGood&&(validR[j]=='2'||validR[j]=='5'||validR[j]=='6'||validR[j]=='9'))
				isGood = true;
			sum+=validCombination(original, i+1, isGood, onEdge);
		}
    	return sum;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rotatedDigits002(10));
	}
}
