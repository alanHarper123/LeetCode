package leetCode.problems._390_Elimination_Game;

import java.util.LinkedList;

public class Solution {
    public int lastRemaining(int n) {
        LinkedList<Boolean> isEvens = new LinkedList<>();
        while(n!=1) {
        	if(n%2==0)
        		isEvens.add(true);
        	else 
        		isEvens.add(false);
        	n>>=1;
        }
        int k=1;
        while (!isEvens.isEmpty()) {
        	Boolean isEven = isEvens.pollLast();
        	if(!isEven||(isEvens.size()+1)%2==1)
        		k+=k;
        	else {
        		k+=k-1;
        	}
		}
        return k;	
        
    }
}
