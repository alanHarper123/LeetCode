package leetCode.problems._754_Reach_a_Number;


public class Solution {
    public int reachNumber(int target) {
    	// this problem can be mirrored;
    	if(target<0)
    		target = -target;
    	int moveCount = 1;
    	int sum = 0;
    	while (sum<target) {
			sum+=moveCount++;
		}
    	moveCount--;
    	// if target and sum are both even or odd.
    	// target can be reach by making a left turn.
    	// for example if we make a left turn when moveCount is 1, then sum = sum - 2;
    	// when moveCount is 2, then sum = sum - 4;
    	// when moveCount is 3, then sum = sum - 6;
    	// ----
    	// when moveCount is n, then sum = sum - 2*n;
    	if(sum==target||sum%2==target%2) {
    		return moveCount;
    	}
    	// sum will turn from even to odd or odd to even by 1 move step if condition are true
    	// or else by 2 step(make left turn up to twice)
    	if((moveCount+1)%2==1)
    		return moveCount+1;
    	return moveCount+2;
    }
}
/*
754. Reach a Number
Medium

You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:

Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.

Example 2:

Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.

Note:
target will be a non-zero integer in the range [-10^9, 10^9].
*/
