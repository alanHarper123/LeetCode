package leetCode.problems._171_Excel_Sheet_Column_Number;

class Solution {
    public int titleToNumber(String s) {
    	int result=0;
        int k = 1;
        int a = ((int)'A')-1;
        for (int i = s.length()-1; i > -1; i--,k*=26) {
			int ai = ((int)s.charAt(i))-a;
			result+=k*ai;
		}
        return result;
    }
    public static void main(String[] args) {
		String[] testData = {
				"A",
				"AA",
				"AB",
				"ZY",
				};
		Solution solution = new Solution();
		for (int i = 0; i < testData.length; i++) {
			System.out.println(
					solution.titleToNumber(testData[i]));
		}
	}
}
