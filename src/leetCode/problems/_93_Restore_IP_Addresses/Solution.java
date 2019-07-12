package leetCode.problems._93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        if(s.length()<4||s.length()>12)
        	return result;
        backTrack( s,result, new ArrayList<>(),0);
        
        return result;
    }
    private void backTrack(String s,ArrayList<String> result,ArrayList<String> newString,int start) {

    	if(newString.size()==4) {
    		if(start==s.length()) {
    			String stemp = "";
    			for (int i = 0; i < newString.size(); i++) {
					stemp += newString.get(i);
					if(i!=newString.size()-1)
						stemp+=".";
				}
    			result.add(stemp);
    		}else
    			return;
    	}
    	for (int j = 1; j < 4&&j<=s.length()-start; j++) {
    		if(s.charAt(start)=='0'&&j>1)
    			break;
			String hi = s.substring(start,j+start);
			if(Integer.valueOf(hi)>255)
				return;
			newString.add(hi);
			backTrack( s,result, newString,start+j);
			newString.remove(newString.size()-1);
		}
    }
    public static void main(String[] args) {
		String[] testStrings = {
				"010010","25525511135"
		};
		Solution solution = new Solution();
		for (int i = 0; i < testStrings.length; i++) {
			System.out.println(solution.restoreIpAddresses(testStrings[i]));
		}
	}
}
