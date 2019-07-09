package leetCode.problems._77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }
    private void backTrack(List<List<Integer>>result,List<Integer> list, int n,int k,int start) {

    	if (list.size()==k) {
    		result.add(new ArrayList<>(list));
    		return;
    	}
    	if(list.size()+n-start+1<k) {
    		return;
    	}
    	for (int i = start; i <= n; i++) {
        	list.add(i);
        	backTrack(result, list, n, k, i+1);
        	list.remove(list.size()-1);
		}

    }
	public static void main(String[] args) {
		int[][]test = {
				{4,3},
				{4,2},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int[] js = test[i];
			System.out.println(solution.combine(js[0], js[1]));
		}
	}
}
