package leetCode.problems._844_Backspace_String_Compare;

public class Solution {
	private int[] indexs;
    public boolean backspaceCompare(String S, String T) {
    	indexs = new int[] {S.length()-1,T.length()-1};

        while (indexs[0]>=0) {
			Character sc = nextChar(S, 0);
			Character tc = nextChar(T, 1);
			if(sc!=null&&!sc.equals(tc))
				return false;
		}
        Character tc = nextChar(T, 1);
        return tc==null;
    }
    private Character nextChar(String s, int i) {
    	int backC=0;
    	while (indexs[i]>=0) {
			if(s.charAt(indexs[i])=='#') {
				backC++;
			}else if(backC>0){
				backC--;
			}else {
				return s.charAt(indexs[i]--);
			}
			indexs[i]--;	
		}
    	return null;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		System.out.println(solution.backspaceCompare("a#c", "b"));
	}

}
