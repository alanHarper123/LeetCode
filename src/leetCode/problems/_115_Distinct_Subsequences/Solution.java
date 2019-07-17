package leetCode.problems._115_Distinct_Subsequences;

public class Solution {
	public int numDistinct(String s, String t) {
		if(s.length()<t.length())
			return 0;
		int[][]base=new int[2][s.length()+1];
		for (int i = 0; i < s.length()+1; i++) {
			base[0][i]=1;
		}
		int currentR=0;
		int preR=0;
		for (int i = 1; i < t.length()+1; i++) {
			currentR = i%2;
			preR=currentR==0?1:0;
			base[currentR][0]=0;	
			for (int j = 1; j < s.length()+1; j++) {
				if(t.charAt(i-1)==s.charAt(j-1)) 
					base[currentR][j]=base[preR][j-1]
							+base[currentR][j-1];
				else 
					base[currentR][j]=base[currentR][j-1];
			}
		}
		return base[currentR][s.length()];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numDistinct("rabbbit","rabbit"));
	}
}
