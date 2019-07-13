package leetCode.problems._97_Interleaving_String;


public class Solution {
	//first try (barely pass)
	public boolean isInterleave(String s1, String s2, String s3) {
		int i,j,k;
		i=s3.length()-1;
		j=s1.length()-1;
		k =s2.length()-1;
		if(k+j+1!=i)
			return false;
		return isInterleaveSub(s1,j,s2,k,s3,i);
	}
	private boolean isInterleaveSub(String s1,int j,
			String s2,int k, String s3,int i){
		for (; i >= 0; i--) {
			if (j>=0&&s3.charAt(i)==s1.charAt(j)) {
				int count = 1;
				if(k>=0&&s3.charAt(i)==s2.charAt(k)) {
					int l=j, m=k, n=i;
					char temp = s3.charAt(n);
					while (l>0&&m>0&&
							temp==s3.charAt(--n)&&
							s3.charAt(n)==s1.charAt(--l)
							&&s3.charAt(n)==s2.charAt(--m)) {
						count++;
					}
					if(isInterleaveSub(s1,j,s2,k-count,s3,i-count))
						return true;
				}
				j-=count;
				i-=count-1;
			}	
			else if (k>=0&&s3.charAt(i)==s2.charAt(k)) 
				k--;
			else 
				return false;
		}
		if(j==-1&&k==-1)
			return true;
		return false;
	}
	//second try, copy, use DP
	public boolean isInterleaveTry02(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length())
			return false;
		boolean[] result = new boolean[s1.length()+1];
		result[0]=true;
		int k = 0;
		while (k<s1.length()&&s3.charAt(k)==s1.charAt(k)) {
			result[++k]=true;		
		}
		for (int i = 0; i < s2.length(); i++) {
			for (int j = 0; j < result.length; j++) {
				if(j!=0) {
					if((result[j])&&s3.charAt(i+j)==s2.charAt(i)||
							(result[j-1]&&s3.charAt(i+j)==s1.charAt(j-1)))
						result[j]=true;
					else 
						result[j]=false; 
				}else if(s2.charAt(i)!=s3.charAt(i))
							result[j]=false;
			}
		}
		return result[result.length-1];

	}
	public static void main(String[] args) {
		String[][] testStrings = {
				{"abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb",
					"ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc",
					"cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"
				},
				{"cabbacccabacbcaabaccacacc",
					"bccacbacabbabaaacbbbbcbbcacc",
				"cbccacabbacabbbaacbcacaaacbbacbcaabbbbacbcbcacccacacc"},
				{"aabccc", "dbbca","aadbbcbcacc"},
				{"aabcc","dbbca","aadbbbaccc"},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testStrings.length; i++) {
			System.out.println("------------------");
			System.out.println(solution.isInterleave(testStrings[i][0], testStrings[i][1], testStrings[i][2]));
			System.out.println("111111111111111111");
			System.out.println(solution.isInterleaveTry02(testStrings[i][0], testStrings[i][1], testStrings[i][2]));
		}
		String s1 = "asddadd"; String s2 ="ddhddadddd";
		System.out.println("+++++");
		System.out.println(s1.substring(4,6)==s2.substring(5,7));
	}

}
