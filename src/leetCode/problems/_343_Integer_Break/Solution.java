package leetCode.problems._343_Integer_Break;

public class Solution {
	private int[] base;
    public int integerBreak(int n) {
        if(n<2)
        	return 0;
       base = new int[n+1];
       base[1]=1;
       base[2]=1;
       int max = 0;
        for (int i = 3; i < base.length; i++) {	
			for (int j = 1; j <= i/2; j++) {
				int temp = Math.max(j, base[j])*Math.max(i-j, base[i-j]);
				if(temp>max)
					max = temp;
			}
			base[i]=max;
		}
        return base[n];
    }

}
