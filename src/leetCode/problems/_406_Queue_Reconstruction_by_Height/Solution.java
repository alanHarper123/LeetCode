package leetCode.problems._406_Queue_Reconstruction_by_Height;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	//N*logN
    public int[][] reconstructQueue(int[][] people) {
    	if(people==null||people.length==1)
    		return people;
    	int k=1;
    	while (k<people.length) {
			k<<=1;
		}
    	// using segmented tree to calculate available index;
        int[] availableIndexs = new int[2*k-1];
        int[][] reconstructedQueue = new int[people.length][2];
        for (int i = k-1; i < k-1+people.length; i++) {
        	availableIndexs[i]=1;
		}
        for (int i = k-2; i >=0; i--) {
        	availableIndexs[i]=availableIndexs[2*i+1]+availableIndexs[2*i+2];
		}
        Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[0]==arr2[0])
					return arr2[1]-arr1[1];
				else {
					return arr1[0]-arr2[0];
				}
			}
		});
        for (int i = 0; i < people.length; i++) {
			reconstructedQueue[getIndex(people[i][1]+1, availableIndexs,k)]=people[i];
		}
        
        return reconstructedQueue;
    }
    private int getIndex(int count,int[] availableIndexs,int k) {
    	int i = 0;
    	while(i<k-1) {
    		availableIndexs[i]--;
    		if(count<=availableIndexs[2*i+1])
    			i=2*i+1;
    		else {
    			count-=availableIndexs[2*i+1];
    			i=2*i+2;
    		}
    	}
    	availableIndexs[i]--;
    	return i-k+1;
    	
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] test = new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		System.out.println(solution.reconstructQueue(test));
	}
}
