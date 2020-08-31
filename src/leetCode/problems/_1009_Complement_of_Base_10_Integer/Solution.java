package leetCode.problems._1009_Complement_of_Base_10_Integer;

public class Solution {
    public int bitwiseComplement(int N) {
        int k = 1;
        if(N==0)
        	return 1;
        int res = 0;
        while (k<N) {
			if((k&N)==0) 
				res+=k;
			k<<=1;
		}
        return res;
    }
}
