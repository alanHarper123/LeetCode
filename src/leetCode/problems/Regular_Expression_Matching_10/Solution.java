package leetCode.problems.Regular_Expression_Matching_10;


class Solution {
	public boolean isMatch(String s, String p) {
		System.out.println(""+s.length()+" "+p.length());
		if(p.isEmpty()) return s.isEmpty();
		boolean firstMatch = !s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
		if(p.length()>=2&&p.charAt(1)=='*') {
			return (firstMatch&&isMatch(s.substring(1), p))||isMatch(s, p.substring(2));
		}else {
			return firstMatch&&isMatch(s.substring(1), p.substring(1));
		}
		
	}
	public static void main(String[] args) {

		String[] strings = {"aabc"};
		String[] regexs = {".a*b*c*abc"};
		Solution solution = new Solution();
		for (int i = 0; i < regexs.length; i++) {
			System.out.println(strings[i].matches(regexs[i]));
			System.out.println(solution.isMatch(strings[i], regexs[i]));
		}
	}
}
