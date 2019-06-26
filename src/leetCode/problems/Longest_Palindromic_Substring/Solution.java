package leetCode.problems.Longest_Palindromic_Substring;



class Solution {
    public String longestPalindrome(String s) {
    	int[] result = new int[2];
    	char[] chars = s.toCharArray();
    	int maxLength = 0;
    	for (int i = 0; i < chars.length; i++) {
			for(int j=1;;j++) {
				int low = i-j;
				int high = i+j;
				if(low<0||high>chars.length-1||chars[low]!=chars[high]) {
					if(2*j-1>maxLength) {
						maxLength = 2*j-1;
						result[0] = low+1;
						result[1] = high;
					}
					break;
				}
			}
			for(int k=1;;k++) {
				int low = i-k+1;
				int high = i+k;
				if(low<0||high>chars.length-1||chars[low]!=chars[high]) {
					if(2*k-2>maxLength) {
						maxLength = 2*k-2;
						result[0] = low+1;
						result[1] = high;
					}
					break;
				}
			}
			
		}
    	return s.substring(result[0], result[1]);
        
    }
}
