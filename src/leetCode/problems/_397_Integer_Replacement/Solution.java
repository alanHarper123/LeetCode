package leetCode.problems._397_Integer_Replacement;

public class Solution {
	private final static int oddMask = 3;
    public int integerReplacement(int n) {
        int count = 0;
        if(n<1)
        	return count;
        while(n!=1) {
        	if(n%2==1) {
        		if(n>oddMask&&(n&oddMask)==oddMask)
        			n++;
        		else 
					n--;
        	}else {
        		
        		n>>>=1;
        		
        	}
        	count+=1;
        }
        return count;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.integerReplacement(2147483647));
	}
}
