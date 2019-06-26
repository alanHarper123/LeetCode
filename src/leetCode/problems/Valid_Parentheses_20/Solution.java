package leetCode.problems.Valid_Parentheses_20;

import java.util.HashMap;

import java.util.LinkedList;


class Solution {
	static final HashMap<Character, Character> hashMap;
	static {
		hashMap = new HashMap<>(7);
		hashMap.put('(', ')');
		hashMap.put('{', '}');
		hashMap.put('[', ']');
	}

    public boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
			if(hashMap.containsKey(c)) {
				stack.add(c);
			}else {
				Character c2 = stack.pollLast();
				if(c2==null||hashMap.get(c2)!=c) {
					return false;
				}
			}
			
		}
        
        return stack.size()==0?true:false;
    }
}
