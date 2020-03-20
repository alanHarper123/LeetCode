package leetCode.problems._331_Verify_Preorder_Serialization_of_a_Binary_Tree;

public class Solution {
	public boolean isValidSerialization(String preorder) {
		int leftBoneC = 0;
		boolean leftBoneN = false;
		for (int i=0; i<preorder.length();i++) {
			if(preorder.charAt(i)=='#') {
				if(leftBoneN) {
					if(leftBoneC!=0)
						leftBoneC--;
					else 
						return false;
				}else {
					leftBoneN = true;
				}
				i++;
			}else {
				if(leftBoneN==true) {
					if(leftBoneC==0)
						return false;
					leftBoneN = false;
				}	
				else 
					leftBoneC++;
				while (i<preorder.length()&&preorder.charAt(i)!=','
						) {
					i++;
				}
			}

		}
		return leftBoneC==0&&leftBoneN;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isValidSerialization("9,#,92,#,#"));
	}
}
