package leetCode.problems.Generate_Parentheses_22;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



class Solution {
    public List<String> generateParenthesis(int n) {
    	

        List<String> results = new LinkedList<>();
        generateAll(results, "", 0, 0, n);
        return results;
    }
    private void generateAll(List<String> results,String result, int openPc,int closePc, int n) {
    	if(closePc == n) {
    		results.add(result);
    		return;
    	}
    	if(openPc<n) {
    		generateAll(results, result+"(", openPc+1, closePc, n);
    	}
    	if(closePc<openPc) {
    		generateAll(results, result+")", openPc, closePc+1, n);
    	}
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	List<String> results = solution.generateParenthesis(3);
    	for (String result : results) {
			System.out.println(result);
		}
	}
}