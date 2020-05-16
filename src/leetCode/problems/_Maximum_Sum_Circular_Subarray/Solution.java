package leetCode.problems._Maximum_Sum_Circular_Subarray;

public class Solution {
	public int maxSubarraySumCircular(int[] A) {
		if(A==null||A.length==0)
			return 0;
		if(A.length==1)
			return A[0];
		int[] compressedArr = new int[A.length];
		int sumi;
		int compressedArri=0;
		int singleMax = Integer.MIN_VALUE;
		for (int i = 0; i < compressedArr.length; ) {
			sumi=0;
			if(A[i]>=0) {
				while (i<compressedArr.length&&A[i]>=0) {
					if(A[i]>singleMax)
						singleMax = A[i];
					sumi+=A[i++];
				}
				if(i<compressedArr.length||compressedArr[0]<0) {
					compressedArr[compressedArri++]=sumi;
				}else {
					compressedArr[0]+=sumi;
				}
			}else {
				while (i<compressedArr.length&&A[i]<0) {
					if(A[i]>singleMax)
						singleMax = A[i];
					sumi+=A[i++];
				}
				if(i<compressedArr.length||compressedArr[0]>=0) {
					compressedArr[compressedArri++]=sumi;
				}else {
					compressedArr[0]+=sumi;
				}
			}
		}
		if(compressedArri<=1) {
			if(compressedArr[0]>0)
				return compressedArr[0];
			else 
				return singleMax;
		}
		int maxNegativeSumi = 0;
		int maxNegativeSum = Integer.MAX_VALUE;
		int maxPositiveSumi = 0;
		int maxPositiveSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < compressedArri; i++) {
			sum+=compressedArr[i];
			maxNegativeSumi+=compressedArr[i];
			maxPositiveSumi+=compressedArr[i];
			if(compressedArr[i]>=0) {
				if(maxPositiveSum<maxPositiveSumi)
					maxPositiveSum = maxPositiveSumi;
				if(maxNegativeSumi>=0) 
					maxNegativeSumi=0;
					
			}else {
				if(maxPositiveSumi<=0)
					maxPositiveSumi = 0;
				if(maxNegativeSumi<maxNegativeSum)
					maxNegativeSum = maxNegativeSumi;
			}
		}

		return Math.max(maxPositiveSum,sum-(maxNegativeSum==Integer.MAX_VALUE?0:maxNegativeSum));
	}
}
