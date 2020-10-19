package leetCode.problems._1189_Maximum_Number_of_Balloons;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (int i = 0; i < text.length(); i++) {
			counts[text.charAt(i)-'a']++;
		}
        int min = Integer.MAX_VALUE;
        String ones = "ban";
        String twos = "lo";
        for (int i = 0,val; i < ones.length(); i++) {
        	val = counts[ones.charAt(i)-'a'];
			if(val<min)
				min = val;
		}
        for (int i = 0,val; i < twos.length(); i++) {
        	val = counts[twos.charAt(i)-'a']/2;
			if(val<min)
				min = val;
		}
        return min;
    }
}
