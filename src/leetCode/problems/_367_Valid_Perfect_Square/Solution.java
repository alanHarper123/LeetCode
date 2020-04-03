package leetCode.problems._367_Valid_Perfect_Square;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 0;
        while (i*i<num) {
        	int k=1;
        	while ((i+k)*(i+k)<num) {
        		i+=k;
        		k<<=1;
			}
        	if(k==1)
        		break;
		}
        return i*i==num;
    }
}
