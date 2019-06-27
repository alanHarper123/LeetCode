package leetCode.problems._33_Search_in_Rotated_Sorted_Array;

class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        if(nums.length==0) {
        	return result;
        }
        int pivot = nums.length/2;
        int aMin = 0;
        int aMax = nums.length-1;
        if(nums[0]>nums[nums.length-1]) {
        	while (nums[(pivot-1+nums.length)%nums.length]<nums[pivot]) {
    			if(nums[pivot]>nums[aMax]) {
    				aMin = pivot;
    				pivot = (pivot+aMax+1)/2;
    				
    			}else {
    				aMax=pivot;
    				pivot = (pivot+aMin)/2;
    				
    			}
    		}
        }else {
			pivot=0;
		}
        
        int i = ((2*pivot+nums.length)/2)%nums.length;
        int bMin = pivot;
        int bMax = (nums.length-1+pivot)%nums.length;
        if(target>nums[bMax]||target<nums[bMin]) {
        	return result;
        }
        while ((bMin<pivot?bMin+nums.length:bMin)<=(bMax<pivot?bMax+nums.length:bMax)) {
			if(target>nums[i]) {
				bMin = (i+1)%nums.length;
				if(pivot!=0&&i>pivot&&bMax<pivot) {
					
					i = ((i+bMax+nums.length+1)/2)%nums.length;
				}else {
					i=(i+bMax+1)/2;
				}
				
			}else if (target<nums[i]) {
				bMax = i==0?nums.length-1:i-1;
				if(pivot!=0&&i<pivot&&bMin>=pivot) {
					i = ((i+nums.length+bMin)/2)%nums.length;
				}else {
					i=(i+bMin)/2;
				}
			}else {
				result=i;
				break;
			}
		}
        return result;
    }
}
