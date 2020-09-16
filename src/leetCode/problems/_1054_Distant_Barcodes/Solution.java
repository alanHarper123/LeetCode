package leetCode.problems._1054_Distant_Barcodes;

import java.util.Arrays;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
    	int max = 0;
    	for(int bc:barcodes) {
    		if(bc>max)
    			max=bc;
    	}
        	
        int[][] buckets = new int[max+1][2];
        for (int i = 0; i < buckets.length; i++) {
			buckets[i][1]=i;
		}
        for(int bc:barcodes)
        	buckets[bc][0]++;
        Arrays.sort(buckets,(ar1,ar2)->ar2[0]-ar1[0]);
        int i=0,j = 0;
        while (j<barcodes.length) {
        	int val = buckets[i][1];
        	int c = buckets[i][0];
        	while (j<barcodes.length&&c>0) {
				barcodes[j] = val;
				c--;
				j+=2;
			}
        	buckets[i][0] = c;
        	if(j>=barcodes.length)
        		break;
        	i++;
		}
        j=1;
        while (j<barcodes.length) {
        	int val = buckets[i][1];
        	int c = buckets[i][0];
        	while (j<barcodes.length&&c>0) {
				barcodes[j] = val;
				c--;
				j+=2;
			}
        	i++;
		}
        return barcodes;
    }
}
/*
1054. Distant Barcodes
Medium

In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.

 

Example 1:

Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]

Example 2:

Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]

 

Note:

    1 <= barcodes.length <= 10000
    1 <= barcodes[i] <= 10000
*/