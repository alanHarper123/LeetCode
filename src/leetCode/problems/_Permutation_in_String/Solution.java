package leetCode.problems._Permutation_in_String;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null)
        	return true;
        if(s2==null)
        	return false;
        if(s1.length()==0)
        	return true;
        if(s1.length()>s2.length())
        	return false;
        int[] letterCs = new int[26];
        int allLetterC = s1.length();
        for (int i = 0; i < s1.length(); i++) {
			letterCs[s1.charAt(i)-'a']++;
		}
        int lefti = 0;
        int righti = 0;
        for (; righti < s1.length(); righti++) {
        	int index = s2.charAt(righti)-'a';
        	letterCs[index]--;
        	if(letterCs[index]>=0)
        		allLetterC--;
		}
        if(allLetterC==0)
        	return true;
        for (; righti < s2.length(); righti++,lefti++) {
        	int indexr = s2.charAt(righti)-'a';
        	int indexl = s2.charAt(lefti)-'a';
        	letterCs[indexr]--;
        	if(letterCs[indexr]>=0)
        		allLetterC--;
        	letterCs[indexl]++;
        	if(letterCs[indexl]>0)
        		allLetterC++;
        	if(allLetterC==0)
        		return true;
		}
        return false;
        
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		System.out.println(solution.checkInclusion("adc", "dcda"));
	}
}
