package leetCode.problems._686_Repeated_String_Match;

public class Solution {
    public int repeatedStringMatch(String A, String B) {
    	int index = B.indexOf(A);
        if(index!=-1) {	
        	int count = 0;
        	if(index!=0)
        		count++;
        	if(!A.endsWith(B.substring(0, index)))
        		return -1;
        	int endIndex=index;
        	do {
        		count++;
        		if(endIndex!=index)
        			return -1;
				endIndex = index+A.length();
			} while ((index=B.indexOf(A,endIndex))>=0);
        	if(!A.startsWith(B.substring(endIndex)))
        		return -1;
        	if(endIndex!=B.length())
        		count++;
        	return count;
        }else {
        	if(A.indexOf(B)>=0)
        		return 1;
        	Loop1:for (int i = 0; i < A.length(); i++) {
        		int Ai;
        		for (int j = 0; j < B.length(); j++) {
    				Ai = i+j;
    				if(Ai>=A.length())
    					Ai-=A.length();
    				if(A.charAt(Ai)!=B.charAt(j))
    					continue Loop1;
    			}
        		return 2;
    		}
        	
        	return -1;
        }
        
    }
}
/*
 Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

 */
