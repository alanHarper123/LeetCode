package leetCode.problems._592_Fraction_Addition_and_Subtraction;

public class Solution {
	private int[] primes = new int[] {2,3,5,7};
    public String fractionAddition(String expression) {
    	boolean isNegative = false;
    	int start = 0;
    	int[] numerators = new int[11];
    	if(expression.charAt(start)=='-') {
    		start++;
    		isNegative = true;
    	}
    	int numerator;
    	int denominator;
        for (int i = start;;) {
			numerator = expression.charAt(i++)-'0';
			if(expression.charAt(i)!='/') {
				numerator*=10;
				numerator += expression.charAt(i++)-'0';
			}
			if(isNegative)
				numerator=-numerator;
			i++;
			denominator = expression.charAt(i++)-'0';
			if(i<expression.length()&&expression.charAt(i)>='0') {
				denominator*=10;
				denominator += expression.charAt(i++)-'0';
			}
			numerators[denominator]+=numerator;
			if(i<expression.length()) {
				if(expression.charAt(i++)=='-')
					isNegative = true;
				else {
					isNegative = false;
				}
			}else 
				break;	
		}
        numerator=0;
        denominator=1;
        for (int i = 1; i < numerators.length; i++) {
			if(numerators[i]!=0) {
				denominator*=i;
			}	
		}
        for (int i = 1; i < numerators.length; i++) {
			if(numerators[i]!=0) {
				numerator+=numerators[i]*(denominator/i);
			}
		}
        if(numerator==0)
        	return "0/1";
        for (int prime:primes) {
			while(numerator%prime==0&&denominator%prime==0) {
				numerator/=prime;
				denominator/=prime;
			}
		}
        return ""+numerator+"/"+denominator;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.fractionAddition("5/3+1/3"));
	}
}
