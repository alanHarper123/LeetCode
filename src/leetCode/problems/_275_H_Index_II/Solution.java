package leetCode.problems._275_H_Index_II;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0)
    		return 0;
        for (int i = 0; i < citations.length; i++) {
			if(citations[citations.length-1-i]<i+1)
				return i;
		}
        return citations.length;
    }
}
