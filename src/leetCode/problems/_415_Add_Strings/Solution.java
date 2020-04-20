package leetCode.problems._415_Add_Strings;

public class Solution {
	public String addStrings(String num1, String num2) {
		if(num1.length()>num2.length()) {
			String temp = num2;
			num2 = num1;
			num1 = temp;
		}
		int i=0,n1l = num1.length()-1, n2l = num2.length()-1;
		boolean isUpdate = false;
		StringBuilder stringBuilder = new StringBuilder();
		for (; i < num2.length(); i++) {
			int n1=num2.charAt(n2l-i)-'0';
			if(n1l-i>=0) {
				n1 += num1.charAt(n1l-i)-'0';
			}
			if(isUpdate)
				n1++;
			stringBuilder.append(n1%10);
			isUpdate = n1/10!=0;
		}
		if(isUpdate)
			stringBuilder.append(1);
		return stringBuilder.reverse().toString();
	}
}
