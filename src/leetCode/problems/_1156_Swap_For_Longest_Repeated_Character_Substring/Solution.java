package leetCode.problems._1156_Swap_For_Longest_Repeated_Character_Substring;

public class Solution {
	public int maxRepOpt1(String text) {
		int [] counts = new int[26];
		int maxLen = 0;
		for (int i = 0; i < text.length(); i++) {
			counts[text.charAt(i)-'a']++;
		}
		int count = 1,nextCount;
		char preChar='A',curChar='A';
		for (int i = 0; i < text.length(); i++) {
			curChar = text.charAt(i);
			if(curChar==preChar) {
				count++;
			}else {
				if(i!=0) {
					if(i+1<text.length()&&text.charAt(i+1)==preChar) {
						nextCount = getDupCount(text, i+1);
						count += nextCount+1;
						if(counts[preChar-'a']<count)
							count--;
						if(count>maxLen)
							maxLen = count;
						if(nextCount!=1) {
							i+=nextCount;
							count = nextCount;
						}else {
							count = 1;
							preChar = curChar;
						}
						
					}else {
						if(counts[preChar-'a']>count)
							count++;
						if(count>maxLen)
							maxLen = count;
						count = 1;
						preChar = curChar;
					}
				}else {
					count = 1;
					preChar = curChar;
				}
			}
		}
		if(counts[curChar-'a']>count)
			count++;
		if(count>maxLen)
			maxLen = count;
		return maxLen;
	}
	private int getDupCount(String text,int index) {
		char ori = text.charAt(index);
		int i = index+1;
		for (; i < text.length(); i++) {
			if(text.charAt(i)!=ori)
				break;
		}
		return i-index;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().maxRepOpt1("aabaaabaaaba"));
	}
}
