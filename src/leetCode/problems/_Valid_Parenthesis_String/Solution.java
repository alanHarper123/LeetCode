package leetCode.problems._Valid_Parenthesis_String;


import java.util.LinkedList;

public class Solution {
    public boolean checkValidString(String s) {
        LinkedList<Integer> compacts = new LinkedList<>();
        LinkedList<Boolean> compactIsStar = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='(') {
				if(compacts.isEmpty()||compactIsStar.peekLast()) {
					compacts.add(1);
					compactIsStar.add(false);
				}else {
					compacts.add(compacts.pollLast()+1);
				}
			}
			else if(c=='*') {
				if(compacts.isEmpty()||!compactIsStar.peekLast()) {
					compacts.add(1);
					compactIsStar.add(true);
				}else {
					compacts.add(compacts.pollLast()+1);
				}
				
			}else if(c==')') {
				if(compacts.isEmpty())
					return false;
				else {
					int starCount = 0;
					if(compactIsStar.peekLast()) {
						starCount=compacts.pollLast();
						compactIsStar.pollLast();
					}
					if(compacts.isEmpty()) {
						starCount--;
						if(starCount<0)
							return false;
					}else {
						int leftBC = compacts.pollLast();
						if(leftBC!=1)
							compacts.add(leftBC-1);
						else
							compactIsStar.pollLast();
					}
					if(starCount!=0) {
						if(!compactIsStar.isEmpty()&&compactIsStar.peekLast()) {
							compacts.add(compacts.pollLast()+starCount);
						}else {
							compacts.add(starCount);
							compactIsStar.add(true);
						}
					}	
				}
			}
        }
        int starC = 0;
        int leftBC = 0;
        while(!compacts.isEmpty()) {
        	if(compactIsStar.peekLast()) {
        		starC+=compacts.pollLast();
        		compactIsStar.pollLast();
        	}else {
        		leftBC += compacts.pollLast();
        		starC-=leftBC;
        		if(starC<0)
        			return false;
        		leftBC=0;
        		compactIsStar.pollLast();
        	}	
        }
        return true;
    }
    public static void main(String[] args) {
    	LinkedList<Boolean> compactIsStar = new LinkedList<>();
    	Solution solution = new Solution();
    	System.out.println(solution.checkValidString("()"));
	}
}
