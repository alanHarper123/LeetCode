package leetCode.problems._921_Minimum_Add_to_Make_Parentheses_Valid;

public class Solution {
    public int minAddToMakeValid(String S) {
        int leftC = 0;
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i)=='(') {
				leftC++;
			}else {
				leftC--;
				if(leftC<0) {
					sum-=leftC;
					leftC=0;
				}
			}
		}
        return sum+leftC;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().minAddToMakeValid("())") );
	}
}
