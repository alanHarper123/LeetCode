package leetCode.problems._342_Power_of_Four;

public class Solution {
	public boolean isPowerOfFour(int num) {
		while (num>0) {
			if(num==1)
				return true;
			else if(num%4!=0)
				return false;

			num/=4;
		}
		return false;
	}
}
