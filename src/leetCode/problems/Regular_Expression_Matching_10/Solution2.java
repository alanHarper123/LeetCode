package leetCode.problems.Regular_Expression_Matching_10;

enum Result {
    TRUE, FALSE
}

class Solution2 {
    Result[][] memo;
    private int count = 0;
        
    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        
        boolean result =  dp(0, 0, text, pattern);
        System.out.println(count);
        return result;
        
    }
    
    
    public boolean dp(int i, int j, String text, String pattern) {
    	System.out.println(""+i+" "+j);
    	count++;
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() && 
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) || 
                       (first_match && dp(i+1, j, text, pattern)));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
    public static void main(String[] args) {

		String[] strings = {"aabc","mississippi","ccabbbabacabaab"};
		String[] regexs = {".a*b*c*abc",".*a*.*a*bb*aac*ac*c"};
		Solution2 solution = new Solution2();
		for (int i = 0; i < regexs.length; i++) {
			System.out.println(strings[i].matches(regexs[i]));
			System.out.println(solution.isMatch(strings[i], regexs[i]));
		}
	}
}
