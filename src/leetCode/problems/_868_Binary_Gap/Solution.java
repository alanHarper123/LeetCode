package leetCode.problems._868_Binary_Gap;

public class Solution {
    public int binaryGap(int N) {
        int count = 0;
        int pre = -1;
        int len = 0;
        while (N>0) {
			if((N&1)==1) {
				if(pre!=-1&&len<count-pre)
					len = count-pre;
				pre = count;
			}
			count++;
			N>>=1;
		}
        return len;
    }
}
