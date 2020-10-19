package leetCode.problems._1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses;

public class Solution {
    public String reverseParentheses(String s) {
        return reverseParenthesesUtil(s, 0, s.length()).toString();
    }
    private StringBuilder reverseParenthesesUtil(String s,int start, int end) {
    	StringBuilder res = new StringBuilder();
    	for (int i = start; i < end; i++) {
    		char val = s.charAt(i);
			if(val!='(') {
				res.append(val);
			}else {
				int leftC = 1;
				for (int j = i+1; j < end; j++) {
					char valt = s.charAt(j);
					if(valt == '(')
						leftC++;
					else if(valt == ')') {
						leftC--;
						if(leftC==0) {
							res.append(reverseParenthesesUtil(s, i+1, j).reverse());
							i = j;
							break;
						}	
					}	
				}
			}
		}
    	return res;
    }
}
