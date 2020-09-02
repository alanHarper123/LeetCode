package leetCode.problems._1013_Partition_Array_Into_Three_Parts_With_Equal_Sum;

public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int e:A) {
			sum+=e;
		}
        if(sum%3!=0)
        	return false;
        int p = 0;
        sum/=3;
        int count = 0;
        for (int e:A) {
			count+=e;
			if(count==sum) {
				count=0;
				p++;
			}
		}
        return sum==0?p>=3:p==3;
    }
}
