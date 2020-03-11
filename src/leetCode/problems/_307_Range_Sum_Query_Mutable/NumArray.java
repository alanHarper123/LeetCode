package leetCode.problems._307_Range_Sum_Query_Mutable;

class SegTree{
	int low;
	int high;
	int val;
	SegTree leftTree;
	SegTree rightTree;
	public SegTree(int low, int high) {
		this.low = low;
		this.high = high;
	}
}
public class NumArray {
	private SegTree segTree;
    public NumArray(int[] nums) {
    	if(nums.length!=0)
    		segTree = buildTree(nums, 0, nums.length-1);
    }
    private SegTree buildTree(int[] nums,
    		int low,int high) {
    	SegTree resultSegTree = new SegTree(low, high);
    	if(high==low) {
    		resultSegTree.val = nums[low];
    	}else {
    		resultSegTree.leftTree = 
    				buildTree(nums, low, low+(high-low)/2);
    		resultSegTree.rightTree = 
    				buildTree(nums, low+(high-low)/2+1, high);
    		resultSegTree.val = resultSegTree.leftTree.val
    				+resultSegTree.rightTree.val;
    	}
    	return resultSegTree;
    	
    }
    private int updateTree(int i, int val,SegTree segTreeLo) {
    	int delta;
    	if(segTreeLo.low==i&&segTreeLo.low==segTreeLo.high) {
    		delta = val - segTreeLo.val;
    	}else {
    		if(i>segTreeLo.low+(segTreeLo.high-segTreeLo.low)/2) {
    			delta = updateTree(i, val, segTreeLo.rightTree);
    		}else {
    			delta = updateTree(i, val, segTreeLo.leftTree);
			}
    	}
    	segTreeLo.val += delta;
    	return delta;
    		
    }
    private int findSum(int i,SegTree seT) {
    	if(seT.high==i)
    		return seT.val;
    	else if(i>seT.low+(seT.high-seT.low)/2){
			return seT.leftTree.val+findSum(i, seT.rightTree);
		}else {
			return findSum(i, seT.leftTree);
		}
    }
    public void update(int i, int val) {
        updateTree(i, val, segTree);
    }
    
    public int sumRange(int i, int j) {
    	if(i!=0) {
    		return findSum(j, segTree)-findSum(i-1, segTree);
    	}else {
    		return findSum(j, segTree);
		}
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
