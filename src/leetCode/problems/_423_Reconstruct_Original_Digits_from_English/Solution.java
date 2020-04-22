package leetCode.problems._423_Reconstruct_Original_Digits_from_English;

import java.util.HashMap;

public class Solution {
	private static char[] decodeCharSeq = new char[] {'z','w','x','g','h','r',
			'o','f','v','i'};
	private static String[] decodeStringSeq = new String[] {"zero","two","six",
			"eight","three","four","one","five","seven","nine"};
	private static int[] decodeSeq = new int[]{0,2,6,8,3,4,1,5,7,9};
    public String originalDigits(String s) {
        
        int[] intCounts = new int[10];
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
			Integer ci = charCounts.get(s.charAt(i));
			if(ci==null)
				ci=0;
			charCounts.put(s.charAt(i), ci+1);
		}
        for (int i = 0; i < decodeCharSeq.length; i++) {
        	if(charCounts.isEmpty())
        		break;
			Integer ci = charCounts.get(decodeCharSeq[i]);
			if(ci!=null) {
				intCounts[decodeSeq[i]] = ci;
				for (int j = 0; j < decodeStringSeq[i].length(); j++) {
					char c = decodeStringSeq[i].charAt(j);
					Integer charC = charCounts.get(c);
					charC-=ci;
					if(charC==0)
						charCounts.remove(c);
					else 
						charCounts.put(c, charC);
				}
			}
		}
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < intCounts.length; i++) {
			for (int j = 0; j < intCounts[i]; j++) {
				stringBuilder.append(i);
			}
		}
        return stringBuilder.toString();
    }
}
