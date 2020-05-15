package leetCode.problems._504_Base_7;

public class Solution {
    public String convertToBase7(int num) {
    	if(num==0)
    		return "0";
        StringBuilder stringBuilder = new StringBuilder();
        boolean isNegative = false;
        if(num<0) {
        	num=-num;
        	isNegative = true;
        }
        while (num!=0) {
			stringBuilder.append(num%7);
			num/=7;
		}
        if(isNegative)
        	stringBuilder.append("-");
        return stringBuilder.reverse().toString();
    }
}
