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
    	// or else by 2 step;
    	if((moveCount+1)%2==1)
    		return moveCount+1;
    	return moveCount+2;
    }
}
