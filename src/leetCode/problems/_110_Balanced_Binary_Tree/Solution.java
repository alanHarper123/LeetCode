package leetCode.problems._110_Balanced_Binary_Tree;



import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
    	if(checkIsBalanced(root)[1]==1)
    		return false;
    	return true;
    }
    private int[] checkIsBalanced(TreeNode root){
    	int[] result = {0,0};
    	if(root == null)
    		return result;
    	result = checkIsBalanced(root.left);
    	if(result[1]==1)
    		return result;
    	int[] resultRight = checkIsBalanced(root.right);
    	if(resultRight[1]==1)
    		return resultRight;
    	if (Math.abs(result[0]-resultRight[0])<2)
    		result[0] = Math.max(result[0], resultRight[0])+1;
    	else 
			result[1]=1;
		
    	return result;
    }
}
