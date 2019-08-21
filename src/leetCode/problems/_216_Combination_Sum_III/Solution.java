package leetCode.problems._216_Combination_Sum_III;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        if(k<1||k>9)
        	return resultList;
        track(resultList, new LinkedList<>(),9,k,n);
        return resultList;
    }
    private void track(List<List<Integer>> resultList,
    		LinkedList<Integer> currentList,int ni,int ki,int n) {
    	if(n<0)
    		return;
    	if(ki==0) {
    		if(n==0) {
    			resultList.add(new LinkedList<>(currentList));
    		}
    		return;	
    	}
    	int min = (1+ki)*ki/2;
    	if(n<min)
    		return;
    	int max = ni*ki-min+ki;
    	if(n>max)
    		return;
    	
    	for (int i = ni; i >= ki; i--) {
    		currentList.addFirst(i);
        	n-=i;
        	ki--;
        	track(resultList, currentList, i-1, ki,n);
        	currentList.removeFirst();
        	ki++;
        	n+=i;
		}
    	
    }
    public static void main(String[] args) {
		int[][] tests = {
				{3,7},
				{3,9},
		};
		Solution solution = new Solution();
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.combinationSum3(
					tests[i][0], tests[i][1]));
		}
	}
}
