package leetCode.problems._405_Convert_a_Number_to_Hexadecimal;

public class Solution {
	private static int hexMask = 1+2+4+8;
    public String toHex(int num) {
        if(num==0)
        	return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (num!=0) {
			int lb = num&hexMask;
			if(lb>9) {
				char lbc = (char) ('a'+lb-10);
				stringBuilder.append(lbc);
			}else {
				stringBuilder.append(lb);
			}
			num>>>=4;
		}
        return stringBuilder.reverse().toString();
    }
}
