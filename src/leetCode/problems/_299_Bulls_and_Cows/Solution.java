package leetCode.problems._299_Bulls_and_Cows;

public class Solution {
    public String getHint(String secret, String guess) {
        int[] base = new int[10];
        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i)==guess.charAt(i))
				bullCount++;
			else {
				base[secret.charAt(i)-'0']++;
			}
		}
        for (int i = 0; i < secret.length(); i++) {
        	if (secret.charAt(i)!=guess.charAt(i)&&
        			base[guess.charAt(i)-'0']-->0) {
				cowCount++;
			}
		}
        return bullCount+"A"+cowCount+"B";
    }
}
