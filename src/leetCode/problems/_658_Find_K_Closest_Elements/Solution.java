package leetCode.problems._658_Find_K_Closest_Elements;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> closestElements = new LinkedList<>();
        int index = Arrays.binarySearch(arr, x);
        int left;
        int right;
        if(index>=0) {
        	left=index-1;
        	closestElements.add(x);
        	right=index+1;
        }else {
        	index = -(index+1);
        	left=index-1;
        	right=index;
        }
        while (closestElements.size()<k) {
			if(left<0) {
				closestElements.add(arr[right++]);
			}else if(right>=arr.length||x-arr[left]<=arr[right]-x){
				closestElements.addFirst(arr[left--]);
			}else {
				closestElements.add(arr[right++]);
			}
		}
        return closestElements;
    }
    
}
