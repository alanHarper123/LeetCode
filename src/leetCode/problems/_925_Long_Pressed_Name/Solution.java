package leetCode.problems._925_Long_Pressed_Name;

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
    	char temp;
    	int j=0;
        for (int i = 0,ci,cj; i < name.length();i++) {
        	temp = name.charAt(i);
			if(j==typed.length())
				return false;
			ci=i;
			while (i+1<name.length()&&name.charAt(i+1)==temp) {
				i++;
			}
			ci=i-ci+1;
			cj=j;
			while (j<typed.length()&&typed.charAt(j)==temp) {
				j++;
			}
			cj=j-cj;
			if(ci>cj)
				return false;
		}
        return j==typed.length();
    }
}
