package leetCode.problems._1079_Letter_Tile_Possibilities;

import java.util.Arrays;

public class Solution {
    public int numTilePossibilities(String tiles) {
        int[] counts = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
			counts[tiles.charAt(i)-'A']++;
        }
        int len = 0;
        for (int i = 0; i < counts.length; i++) {
			if(counts[i]!=0) {
				counts[len++] = counts[i]; 
			}
		}
        int[] uniqueC = Arrays.copyOfRange(counts, 0, len);
        int[] dimensions = new int[len];
        dimensions[len-1] = 1;
        int totalLen = 1;
        for (int i = uniqueC.length-2; i >=0; i--) {
			dimensions[i] = dimensions[i+1]*(uniqueC[i+1]+1);
		}
        totalLen = dimensions[0]*(uniqueC[0]+1);
        int[] dp = new int[totalLen]; 
        calculate(dp, uniqueC, dimensions, tiles.length(), totalLen-1);
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
			sum+=dp[i];
		}
        return sum;
    }
    private void calculate(int[] dp,int[] uniqueC,int[] dimensions,int len,int index) {
    	if(len==0)
    		return;
    	int count = dp[index];
    	if(count == 0) {
    		count = factorial(len);
    		for (int i = 0; i < uniqueC.length; i++) {
    			if(uniqueC[i]>0) {
    				count/=factorial(uniqueC[i]);
    				uniqueC[i]--;
    				calculate(dp, uniqueC, dimensions, len-1, index-dimensions[i]);
    				uniqueC[i]++;
    			}
				
			}
    		dp[index] = count;
    	}
    }
//    private int getIndex(int[] dimensions,int[] indexs) {
//    	int index = 0;
//    	for (int i = 0; i < indexs.length; i++) {
//			index+=dimensions[i]*indexs[i];
//		}
//    	return index;
//    }
    private int factorial(int n) {
    	if(n<=1)
    		return 1;
    	return n*factorial(n-1);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().numTilePossibilities("AAABBC"));
	}
}
/*
1079. Letter Tile Possibilities
Medium

You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:

Input: tiles = "AAABBC"
Output: 188

Example 3:

Input: tiles = "V"
Output: 1

 

Constraints:

    1 <= tiles.length <= 7
    tiles consists of uppercase English letters.
 */