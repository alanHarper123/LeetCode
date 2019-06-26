package leetCode.problems.Count_and_Say_38;



class Solution {
	private String countAndSay(String cs) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < cs.length(); i++) {
			int count = 1;
			while(i+1<cs.length()&&cs.charAt(i)==cs.charAt(i+1)) {
				count++;
				i++;
			}
			stringBuffer.append(count);
			stringBuffer.append(cs.charAt(i));
		}
		return stringBuffer.toString();
		
	}
    public String countAndSay(int n) {
    	if(n!=1) {
    		return countAndSay(countAndSay(n-1));
    	}else {
			return "1";
		}
    }
    public static void main(String[] args) {
    	for(int i=1; i<10;i++) {
    		System.out.println(new Solution().countAndSay(i));
    	}
	}
}
