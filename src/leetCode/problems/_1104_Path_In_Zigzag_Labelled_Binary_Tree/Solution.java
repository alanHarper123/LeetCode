package leetCode.problems._1104_Path_In_Zigzag_Labelled_Binary_Tree;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        int sum = 1;
        int curLen = 1;
        boolean isLeft = true;
        while (label>sum) {
        	isLeft = !isLeft;
        	curLen<<=1;
        	sum+=curLen;
		}
        while (label>0) {
			res.addFirst(label);
			sum -= curLen;
			int dif = label-sum;
			dif = (dif-1)/2+dif;
			label-=dif;
			curLen>>=1;
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().pathInZigZagTree(26));
	}
}
/*
1104. Path In Zigzag Labelled Binary Tree
Medium

In an infinite binary tree where every node has two children, the nodes are labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.

Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

 

Example 1:

Input: label = 14
Output: [1,3,4,14]

Example 2:

Input: label = 26
Output: [1,2,6,10,26]

 

Constraints:

    1 <= label <= 10^6

*/