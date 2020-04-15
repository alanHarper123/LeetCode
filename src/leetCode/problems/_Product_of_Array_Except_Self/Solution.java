package leetCode.problems._Product_of_Array_Except_Self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	//   1 2 3 4
    	// 1 *          1  *  2*3*4
    	// 2   *        1   *   3*4
    	// 3     *      1*2   *   4
    	// 4       *    1*2*3  *  1
        int[] products = new int[nums.length];
        if(nums.length>0)
        	products[nums.length-1]=1;
        if(nums.length-2>=0)
        	products[nums.length-2]=nums[nums.length-2];
        for (int j=nums.length-1; j>=1;j--) {
			products[j-1]=nums[j]*products[j];
		}
        for (int i = 1; i < nums.length-1; i++) {
			nums[i]=nums[i]*nums[i-1];
		}
        if(nums.length>0)
        	nums[nums.length-1]=1;
        for (int i = 1; i < products.length; i++) {
			products[i]=products[i]*nums[i-1];
		}
        return products;
    }
}
