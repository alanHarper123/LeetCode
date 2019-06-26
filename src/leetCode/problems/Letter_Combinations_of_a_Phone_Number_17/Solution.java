package leetCode.problems.Letter_Combinations_of_a_Phone_Number_17;

import java.util.ArrayList;
import java.util.List;

class Solution {
	char[][] keyBoards = {{'a','b','c'},{'d','e','f'},
			{'g','h','i'},{'j','k','l'},{'m','n','o'},
			{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
    	List<Integer> index = new ArrayList<>();
    	List<Integer> poolSizes = new ArrayList<>();
    	List<Integer> numberIndex = new ArrayList<>();
    	List<String> results = new ArrayList<>();
    	if(digits.length() == 0) {
    		return results;
    	}
    	for (int i = 0; i < digits.length(); i++) {
			int a = new Integer(String.valueOf((digits.charAt(i))));
			index.add(a-2);
		}
    	
    	for(Integer i: index) {
    		poolSizes.add(keyBoards[i].length);
    	}
    	for (int i = 0; i < poolSizes.size(); i++) {
			numberIndex.add(0);
		}
    	
    	while (true) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numberIndex.size(); i++) {
				sb.append(keyBoards[index.get(i)][numberIndex.get(i)]);
			}
			results.add(sb.toString());
			for (int i = numberIndex.size()-1; i >=0; i--) {
				if(numberIndex.get(i)<poolSizes.get(i)-1) {
					numberIndex.set(i, numberIndex.get(i)+1);
					break;
				}else {
					if(i==0)
						return results;
					numberIndex.set(i, 0);
				}
					
			}
		}
        
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().letterCombinations("23"));
	}
}
