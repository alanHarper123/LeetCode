package leetCode.problems._481_Magical_String;

import java.util.LinkedList;

public class Solution {
    public int magicalString(int n) {
        LinkedList<Integer> magic1 = new LinkedList<>();
        LinkedList<Integer> magic2 = new LinkedList<>();
        magic1.add(1);
        magic1.add(2);
        int count = 0;
        boolean magic1IsOne = false;
        boolean magic2Isone = true;
        Integer pre = null;
        Integer magic1i = null;
        Integer magic2i = null;
        int m1n = 0;
        int m2n = 0;
        
        while (n>0) {
        	if(magic1i!=null)
        		pre = magic1i;
        	magic1i = magic1.pollFirst();
        	if(pre==null||(magic1i!=null&&pre!=magic1i))
        		m1n++;
//       	if(magic1i!=null)
//        		System.out.println("c1:"+magic1i);
        		

        	if(magic1i!=null) {
//        		System.out.println("m1n: "+m1n);
        		n--;
        		if(magic1i==1)
        			count++;
        		if(magic2Isone) {
        			if(magic1i==1)
        				magic2.add(1);
        			else {
        				magic2.add(1);
        				magic2.add(1);
        			}
        		}else {
        			if(magic1i==1)
        				magic2.add(2);
        			else {
        				magic2.add(2);
        				magic2.add(2);
        			}
        		}
        		magic2Isone = !magic2Isone;
        		
        	}else {
 //       		System.out.println("m2n:"+m2n);
        		while (m2n<m1n) {
                		m2n++;
            		magic2i = magic2.pollFirst();
//            		System.out.println("c2:"+magic2i);
				}
        		if(magic1IsOne) {
        			if(m1n==m2n) {
        				if(magic2i==2)
            				magic1.add(1);
        			}else {
        				if(magic2i==1)
            				magic1.add(1);
            			else {
            				magic1.add(1);
            				magic1.add(1);
            			}
        			}
        				
        		}else {
        			if(m1n==m2n) {
        				if(magic2i==2)
            				magic1.add(2);
        			}else {
        				if(magic2i==1)
            				magic1.add(2);
            			else {
            				magic1.add(2);
            				magic1.add(2);
            			}
        			}
        		}
        		magic1IsOne = !magic1IsOne;
        		m2n++;
        		magic2i = magic2.pollFirst();
//        		System.out.println("c2:"+magic2i);
        	}
			
		}
        return count;
    }
    public static void main(String[] args) {
		Solution spSolution = new Solution();
		System.out.println(spSolution.magicalString(15));
	}
}
