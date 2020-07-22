package leetCode.problems._859_Buddy_Strings;

public class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()||A.length()<2)
        	return false;
        
        boolean swap1 = false;
        char a = 'a';
        char b = 'b';
        for (int i = 0; i < A.length(); i++) {
			if(A.charAt(i)!=B.charAt(i)) {
				if(swap1==false) {
					swap1 = true;
					a = A.charAt(i);
					b = B.charAt(i);
				}else {
					if(a!=B.charAt(i)||A.charAt(i)!=b)
						return false;
					for (int j = i+1; j < A.length(); j++) {
						if(A.charAt(i)!=B.charAt(i))
							return false;
					}
					return true;
				}	
			}
		}
        if(swap1==true)
        	return false;
        boolean[] uniques = new boolean[26]; 
        for (int i = 0,index; i < A.length(); i++) {
			index = A.charAt(i)-'a';
			if(uniques[index])
				return true;
			uniques[index] = true;
		}
        return false;
    }
}
