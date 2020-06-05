package leetCode.problems._640_Solve_the_Equation;

public class Solution {
    public String solveEquation(String equation) {
        String[] statements = equation.split("=");
        int[] abLeft = parseStatements(statements[0]);
        int[] abRight = parseStatements(statements[1]);
        abLeft[0] -= abRight[0];
        abRight[1] -= abLeft[1];
        if(abLeft[0]==0) {
        	if(abRight[1]==0)
        		return "Infinite solutions";
        	return "No solution";
        }
        StringBuilder res = new StringBuilder();
        res.append("x=");
        res.append(abRight[1]/abLeft[0]);
        return res.toString();
    }
    //ax+b
    private int[] parseStatements(String statement){
    	boolean isNegative = false;
    	int a = 0;
    	int b = 0;
    	int ci = 0;
    	char pre = '+';
    	for (int i = 0; i < statement.length(); i++) {
			char c = statement.charAt(i);
			if(c=='-'||c=='+') {
				if(pre=='x') {
					if(isNegative) {
						a-=ci;
					}else {
						a+=ci;
					}
				}else {
					if(isNegative) {
						b-=ci;
					}else {
						b+=ci;
					}
				}
				isNegative = c=='-';
				ci=0;
			}else{
				if(c=='x') {
					if(ci==0&&(pre=='+'||pre=='-'))
						ci=1;
				}else {
					ci*=10;
					ci+=c-'0';
				}
			}
			pre = c;
		}
    	if(pre=='x') {
			if(isNegative) {
				a-=ci;
			}else {
				a+=ci;
			}
		}else {
			if(isNegative) {
				b-=ci;
			}else {
				b+=ci;
			}
		}
    	return new int[] {a,b};
    }
}
