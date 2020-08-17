package leetCode.problems._946_Validate_Stack_Sequences;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean[] isTaken = new boolean[pushed.length];
        int pre = -1;
        int index = pushed.length-1;
        for (int i = 0,val; i < isTaken.length; i++) {
			val = popped[i];
			index = pushed.length-1;
			while (pushed[index]!=val) {
				index--;
			}
			isTaken[index]=true;
			if(index<pre) {
				for (int j = index+1; j < pre; j++) {
					if(!isTaken[j])
						return false;
				}
			}
			pre = index;
		}
        return true;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().validateStackSequences(new int[] {8,2,1,4,7,9,0,3,5,6}, new int[] {1,2,7,3,6,4,0,9,5,8}));
	}
}
