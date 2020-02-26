package leetCode.problems._263_Ugly_Number;

public class Solution {
    public boolean isUgly(int num) {
        //2 3 5
    	if(num<1)
    		return false;
    	else if(num==1)
    		return true;
    	else {
    		while(num!=0&&num%2==0) {
    			if(num==2) {
    				num = 0;
    				break;
    			}	
    			num/=2;
    		}
    		while(num!=0&&num%3==0) {
    			if(num==3) {
    				num = 0;
    				break;
    			}
    			num/=3;
    		}	
    		while(num!=0&&num%5==0) {
    			if(num==5) {
    				num = 0;
    				break;
    			}
    			num/=5;
    		}
    		
    		return num==0;
    		
    	}
    }
}
