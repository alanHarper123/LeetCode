package leetCode.problems.Container_With_Most_Water_11;

class Solution {	
    public int maxArea(int[] height) {
        int result = 0;
        int temp = 0;
        int index1 = 0;
        int index2 = height.length-1;
        while(index1<index2) {
        	if (height[index2]>=height[index1]) {
        		temp = height[index1]*(index2-index1);
        		index1++;
        	}else {
				temp = height[index2]*(index2-index1);
				index2--;
			}
        	if (temp>result) {
				result = temp;
			}
        }
        return result;
    }
    public static void main(String[] args) {
		int[] zxcv = new int[] {8,10,14,0,13,10,9,9,11,11};
		System.out.println(new Solution().maxArea(zxcv));
	}
}
