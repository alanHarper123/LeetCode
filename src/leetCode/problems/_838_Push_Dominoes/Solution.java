package leetCode.problems._838_Push_Dominoes;

public class Solution {
	public String pushDominoes(String dominoes) {
		char[] chars = dominoes.toCharArray();
		int[] signs = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case 'R':
				signs[i] = 1;
				break;
			case '.':
				if(i>0&&chars[i-1]=='R') {
					signs[i] = signs[i-1]+1;
					chars[i] = 'R';
				}
				break;
			default:
				signs[i] = -1;
				break;
			}
		}
		for (int i = signs.length-2; i>=0; i--) {
			switch (chars[i]) {
			case 'R':
				if(chars[i+1]=='L') {
					int judge = signs[i]+signs[i+1]-1;
					if(judge==0)
						chars[i] = '.';
					else if(judge>0) {
						chars[i] = 'L';
						signs[i] = signs[i+1]-1;
					}
				}
				break;
			case '.':
				if(chars[i+1]=='L') 
					chars[i]='L';
				
				break;
			default:
				break;
			}
		}
		return String.valueOf(chars);
	}
}
/*
838. Push Dominoes
Medium

There are N dominoes in a line, and we place each domino vertically upright.

In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left.

Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state. 

Example 1:

Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."

Example 2:

Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.

Note:

    0 <= N <= 10^5
    String dominoes contains only 'L', 'R' and '.'
 */
