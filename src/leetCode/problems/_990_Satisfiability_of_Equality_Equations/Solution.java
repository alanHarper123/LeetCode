package leetCode.problems._990_Satisfiability_of_Equality_Equations;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
        int ci1,ci2,p1,p2;
        for (String equation:equations) {
			if(equation.charAt(1)=='=') {
				ci1 = equation.charAt(0) - 'a';
				ci2 = equation.charAt(3) - 'a';
				p1 = getParent(parent, ci1);
				p2 = getParent(parent, ci2);
				if(p1!=p2) {
					parent[p2] = p1;
				}
			}
		}
        for (String equation:equations) {
			if(equation.charAt(1)=='!') {
				ci1 = equation.charAt(0) - 'a';
				ci2 = equation.charAt(3) - 'a';
				p1 = getParent(parent, ci1);
				p2 = getParent(parent, ci2);
				if(p1==p2) {
					return false;
				}
			}
		}
        return true;
    }
    private int getParent(int[] parent,int i) {
    	if(parent[i]!=i) {
    		parent[i] = getParent(parent,parent[i]);
    	}
    	return parent[i];
    }
}
/*
989. Add to Array-Form of Integer
Easy

For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

 

Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000

 

Note：

    1 <= A.length <= 10000
    0 <= A[i] <= 9
    0 <= K <= 10000
    If A.length > 1, then A[0] != 0
 */