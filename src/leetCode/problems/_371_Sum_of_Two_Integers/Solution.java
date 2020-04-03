package leetCode.problems._371_Sum_of_Two_Integers;

public class Solution {
    public int getSum(int a, int b) {
        boolean upgrade = false;
        
        int aLB=0, bLB=0,ans=0,k=1;
        while (a!=0||b!=0) {
        	aLB = a&1;
        	bLB = b&1;
        	if((aLB^bLB)==1) {
        		if(!upgrade)
        			ans+=k;
        	}else if((aLB&bLB)==1) {
        		if(upgrade)
        			ans+=k;
        		else 
        			upgrade = true;
        	}else {
        		if(upgrade) {
        			ans+=k;
        			upgrade=false;
        		}
        	}
        	a>>>=1;
        	b>>>=1;
        	k<<=1;
		}
        if(upgrade)
        	ans+=k;
        return ans;
    }
}
