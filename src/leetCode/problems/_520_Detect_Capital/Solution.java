package leetCode.problems._520_Detect_Capital;

public class Solution {
	public boolean detectCapitalUse(String word) {
		if(word.length()==1)
			return true;
		int i = 0;
		if(Character.isUpperCase(word.charAt(i))) {
			if(Character.isUpperCase(word.charAt(++i))) {
				for (; i < word.length(); i++) {
					if(Character.isLowerCase(word.charAt(i)))
						return false;
				}
				return true;
			}

		}

		for (; i < word.length(); i++) {
			if(Character.isUpperCase(word.charAt(i)))
				return false;
		}
		return true;

	}
}
