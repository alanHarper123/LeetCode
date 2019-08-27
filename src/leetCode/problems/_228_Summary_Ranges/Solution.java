package leetCode.problems._228_Summary_Ranges;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> result = new LinkedList<>();
        Integer head = null;
        Integer tail = null;
        for (int i = 0; i < nums.length; i++) {
			if(head==null)
				head = nums[i];
			else if(tail==null) {
				if(nums[i]==head+1)
					tail = head+1;
				else {
					result.add(String.valueOf(head));
					head = nums[i];
				}
			}else {
				if(nums[i]==tail+1)
					tail++;
				else {
					result.add(String.valueOf(head)+"->"+String.valueOf(tail));
					head = nums[i];
					tail = null;
				}
			}
		}
        if(head!=null)
        	if(tail==null)
        		result.add(String.valueOf(head));
        	else 
        		result.add(String.valueOf(head)+"->"+String.valueOf(tail));
        	
        return result;
    }
}
