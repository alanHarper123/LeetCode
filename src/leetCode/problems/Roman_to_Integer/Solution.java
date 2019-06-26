package leetCode.problems.Roman_to_Integer;

import java.util.HashMap;


public class Solution {
	private final HashMap<Character, Integer> data = new HashMap<>();
	public Solution() {
		data.put('I', 1);
		data.put('V', 5);
		data.put('X', 10);
		data.put('L', 50);
		data.put('C', 100);
		data.put('D', 500);
		data.put('M', 1000);
	}
	public int romanToInt(String s) {
		int result = 0;
		for(int i=0; i<s.length(); i++) {
			int temp = data.get(s.charAt(i));
			if(i+1<s.length()&&temp<data.get(s.charAt(i+1))) {
				result+=-temp;
			}else {
				result+=temp;
			}
		}
		
		return result;
        
    }
	
	
}
