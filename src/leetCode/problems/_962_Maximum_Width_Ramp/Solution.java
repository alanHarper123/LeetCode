package leetCode.problems._962_Maximum_Width_Ramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
	public int maxWidthRamp(int[] A) {
		int max = 0;
		ArrayList<Integer> vals = new ArrayList<>(A.length);
		ArrayList<Integer> index = new ArrayList<>(A.length);
		vals.add(A[0]);
		index.add(0);
		for (int i = 1,indexi,dif; i < A.length; i++) {

			if(vals.get(vals.size()-1)>A[i]) {
				vals.add(A[i]);
				index.add(i);
			}else {
				indexi = Collections.binarySearch(vals, A[i], Collections.reverseOrder());
				if(indexi<0)
					indexi = -(indexi+1);
				dif = i-index.get(indexi);
				if(dif>max)
					max = dif;
			}

		}
		return max;
	}
}
