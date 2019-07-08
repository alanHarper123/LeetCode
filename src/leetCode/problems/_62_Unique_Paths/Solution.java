package leetCode.problems._62_Unique_Paths;

public class Solution {
    public int uniquePaths(int m, int n) {
    	int Bstart = Math.max(m-1, n-1);
    	if(m<=1||n<=1) 
    		return 1;
        long ln=1;
        long lsum=1;
        
        for (int i = Bstart+1; i < m+n-1; i++) {
        	lsum*=i;
		}
        int Astart = Math.min(m-1, n-1);
        for (int i = 1; i < Astart+1; i++) {
        	ln*=i;
		}
        return (int)(lsum/ln);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(10, 10));
	}
}
