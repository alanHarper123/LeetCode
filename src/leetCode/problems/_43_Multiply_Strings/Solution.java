package leetCode.problems._43_Multiply_Strings;

class Solution {
    public String multiply(String num1, String num2) {

        char[] result = new char[num1.length()+num2.length()];
        for (int i = num1.length()-1; i > -1; i--) {
			for (int j = num2.length()-1; j > -1; j--) {
				int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+result[i+j+1];
				result[i+j+1]=(char)(product%10);
				result[i+j]+=(char)(product/10);
			}
		}
        int notZeroIndex = -1;
        for (int i = 0; i < result.length; i++) {
			if (result[i] == 0) {
				continue;
			}
			notZeroIndex = i; break;
		}
        if (notZeroIndex==-1) {
			return "0";
		}else {
			for (int i = notZeroIndex; i < result.length; i++) {
	        	result[i]+='0';
			}
			return new String(result,notZeroIndex,result.length-notZeroIndex);
		}  
    }
    public static void main(String[] args) {

		String s1 = "123456789";
		String s2 = "987654321";
		System.out.println(new Solution().multiply(s1, s2));
	}
}
