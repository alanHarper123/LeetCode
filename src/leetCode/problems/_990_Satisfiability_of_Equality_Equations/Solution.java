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
990. Satisfiability of Equality Equations
Medium

Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

 

Example 1:

Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.

Example 2:

Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

Example 3:

Input: ["a==b","b==c","a==c"]
Output: true

Example 4:

Input: ["a==b","b!=c","c==a"]
Output: false

Example 5:

Input: ["c==c","b==d","x!=z"]
Output: true

 

Note:

    1 <= equations.length <= 500
    equations[i].length == 4
    equations[i][0] and equations[i][3] are lowercase letters
    equations[i][1] is either '=' or '!'
    equations[i][2] is '='
 */