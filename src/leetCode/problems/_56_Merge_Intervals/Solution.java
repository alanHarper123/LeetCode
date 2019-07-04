package leetCode.problems._56_Merge_Intervals;

import java.util.Arrays;
import java.util.Comparator;
class IntArrayCpmpare implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		for (int i = 0; i < o2.length; i++) {
			if (o1[i]>o2[i]) {
				return 1;
			}else if(o1[i]<o2[i]){
				return -1;
			}
		}
		return 0;
	}

}
public class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new IntArrayCpmpare());
		System.out.println(Arrays.deepToString(intervals));
		if(intervals.length<=1)
			return intervals;
		int validRowN = 0;
		for (int i = 0; i < intervals.length-1; i++) {
			intervals[validRowN][0]=intervals[i][0];
			int maxUpperBound = intervals[i][1];
			while (maxUpperBound>=intervals[i+1][0]) {
				if(maxUpperBound<intervals[i+1][1]) {
					maxUpperBound = intervals[i+1][1];
				}
				if(++i==intervals.length-1) {
					break;
				}
			}
			intervals[validRowN][1]=maxUpperBound;
			if(i+1==intervals.length-1) {
				intervals[++validRowN][0]=intervals[i+1][0];
				intervals[validRowN][1]=intervals[i+1][1];
			}
			validRowN++;
		}
		return Arrays.copyOfRange(intervals, 0, validRowN);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] test = {
				{{1,3},{2,6},{8,10},{15,18}},
				{{2,3},{5,5},{2,2},{3,4},{3,4}},
				{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}},
				{{2,3},{4,5},{6,7},{8,9},{1,10}},
				{{1,4},{4,5}},
				{{1,4},{5,6}},
				{{1,4},{2,3}},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			System.out.println(Arrays.deepToString(solution.merge(test[i])));
		}
	}
}
