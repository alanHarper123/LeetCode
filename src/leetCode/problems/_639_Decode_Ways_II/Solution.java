package leetCode.problems._639_Decode_Ways_II;

public class Solution {
	private static int base = (int) (1E9+7);

    //The length of the input string will fit in range [1, 105].
    //The input string will only contain the character '*' and digits '0' - '9'.
    public int numDecodings(String s) {
        long[] dp =  new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0)=='*')
        	dp[1] = 9;
        else {
        	dp[1] = 1;
        }
        char preC = s.charAt(0);
        if(preC=='0')
        	return 0;
        for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='*') {
				if(preC=='1') {
					dp[i+1] = (dp[i]*9+dp[i-1]*9)%base;
				}else if(preC=='2') {
					dp[i+1] = (dp[i]*9+dp[i-1]*6)%base;
				}else if(preC=='*') {
					dp[i+1] = (dp[i]*9+dp[i-1]*15)%base;
				}else {
					dp[i+1] = (dp[i]*9)%base;
				}
			}else if(c=='0'){
				if(preC=='*') {
					dp[i+1] = (dp[i-1]*2)%base;
				}else {
					if(preC!='*'&&preC!='1'&&preC!='2')
						return 0;
					dp[i+1] = dp[i-1];
				}
			}else{
				if(preC=='1') {
					dp[i+1] = (dp[i]+dp[i-1])%base;
				}else if(preC=='2') {
					if(c>'6')
						dp[i+1] = dp[i];
					else 
						dp[i+1] = (dp[i]+dp[i-1])%base;
				}else if(preC=='*') {
					if(c>'6')
						dp[i+1] = (dp[i]+dp[i-1])%base;
					else 
						dp[i+1] = (dp[i]+dp[i-1]*2)%base;
				}else 
					dp[i+1] = dp[i];
			}
			preC = c;
		}
        return (int) dp[dp.length-1];

    }
}
