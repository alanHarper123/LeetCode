package leetCode.problems._91_Decode_Ways;

public class Solution {
	public int numDecodings(String s) {
		int count = 0;
		int i = 0;
		int sum = 1;
		while (i<s.length()) {
			if(s.charAt(i)<'0'||s.charAt(i)>'9')
				return 0;
			if(s.charAt(i)<'3'&&s.charAt(i)!='0') {
				count++;
			}else if (s.charAt(i)<'7'&&s.charAt(i)!='0') {
				if(count>0) {
					sum*=climbStairs(++count);
					count=0;
				}
			}else {
				if(s.charAt(i)=='0') {
					if(count==0)
						return 0;
					if (count>2) 
						sum*=climbStairs(--count);
				}else {
					if(count!=0&&s.charAt(i-1)=='2') 
						sum*=climbStairs(count);
					else 
						sum*=climbStairs(++count);
				}
				count = 0;
			}
			i++;
		}
		if(count!=0)
			sum*=climbStairs(count);

		return sum;
	}
	public int climbStairs(int n) {
		int r = n/2;
		int sum = 1;
		int sumi=1;
		//sumi = (n-k)!/(n-2*k)!/k!
		for (int k = 1; k < r+1; k++) {
			long l2 = (n-k+1)*k;
			long l1;
			l1 = (n-2*k+1)*(n-2*k+2)/2;
			l1*=sumi;
			sumi = (int)(l1*2/l2);
			sum+=sumi;
		}
		return sum;
	}
	public static void main(String[] args) {
		String[]test = {
				"17",
				"230",
				"110",
				"00",
				"0",
				"10",
				"9",
				"22622",
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			String js = test[i];
			System.out.println(solution.numDecodings(js));
		}
	}
}
