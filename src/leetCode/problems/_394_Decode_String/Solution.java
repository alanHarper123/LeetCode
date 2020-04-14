package leetCode.problems._394_Decode_String;

public class Solution {
    public String decodeString(String s) {
        if(s.indexOf('[')==-1) {
        	return s;
        }else {
        	return decodeStringUtil(s, 0, s.length());
        }
    }
    private String decodeStringUtil(String s,int start,int end) {
    	boolean pregnant = false;
    	int leftBC = 0;
    	int i = start;
    	StringBuilder sb = new StringBuilder();
    	for (; i < end; i++) {
    		char c = s.charAt(i);
			if('0'<c&&c<='9')
				break;
			sb.append(c);
		}
    	int count = 0;
    	for (; i < end; i++) {
    		char c = s.charAt(i);
			if('0'<c&&c<='9') {
				count=count*10+c-'0';
			}else 
				break;
		}
    	int newStart = i+1;
    	for (; i < end; i++) {
    		char c = s.charAt(i);
			if(c=='['&&++leftBC==2) {
				pregnant=true;
			}else if(c==']'&&--leftBC==0) {
				break;
			}
		}
    	String repeatS;
    	if(pregnant) {
    		repeatS = decodeStringUtil(s, newStart, i);
    	}else {
    		StringBuilder nSb = new StringBuilder();
    		for (int j = newStart; j < i; j++) {
    			nSb.append(s.charAt(j));
			}
    		repeatS = nSb.toString();
    	}
    	for (int j = 0; j < count; j++) {
			sb.append(repeatS);
		}
    	i++;
    	int newLBindex = s.indexOf('[', i);
    	if(newLBindex==-1||newLBindex>=end) {
    		for (; i < end; i++) {
				sb.append(s.charAt(i));
			}
    	}else {
    		sb.append(decodeStringUtil(s, i, end));
    	}
    	return sb.toString();
    }
    
}
