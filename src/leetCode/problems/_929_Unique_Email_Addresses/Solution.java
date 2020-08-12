package leetCode.problems._929_Unique_Email_Addresses;

import java.util.HashSet;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        StringBuilder stringBuilder;
        for(String email:emails) {
        	stringBuilder = new StringBuilder();
        	int p = email.indexOf('@');
        	char c;
        	for (int i = 0; i < p; i++) {
        		c = email.charAt(i);
        		if(c=='.')
        			continue;
				if(c=='+')
					break;
				stringBuilder.append(c);
			}
        	stringBuilder.append(email.substring(p));
        	uniqueEmails.add(stringBuilder.toString());
        }
        return uniqueEmails.size();
    }
}
