package leetCode.problems._331_Verify_Preorder_Serialization_of_a_Binary_Tree;

public class Solution {
	public boolean isValidSerialization(String preorder) {
		int leftBoneC = 0;
		boolean leftBoneN = false;
		String[] preorderEls = preorder.split(",");
		for (String s : preorderEls) {
			if(s.equals("#")) {
				if(leftBoneN) {
					if(leftBoneC!=0)
						leftBoneC--;
					else 
						return false;
				}else {
					leftBoneN = true;
				}	
			}else {
				if(leftBoneN==true) {
					if(leftBoneC==0)
						return false;
					leftBoneN = false;
				}
					
				else 
					leftBoneC++;
			}

		}
		return leftBoneC==0&&leftBoneN;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isValidSerialization("#,7,6,9,#,#,#"));
	}
}
