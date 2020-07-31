package leetCode.problems._904_Fruit_Into_Baskets;

public class Solution {
    public int totalFruit(int[] tree) {
        
        int[] fruit = new int[2];
        int[] fCount = new int[2];
        fruit[0] = -1;
        int max = 0;
        for (int i=0,j,count; i < tree.length;) {
        	j=1;
        	count = i;
        	fruit[1] = tree[i];
			while (i+1<tree.length&&tree[i+1]==tree[i]) {
				i++;
			}
			i++;
			count = i-count;
			fCount[1] = count;
			while (i<tree.length&&tree[i]==fruit[1-j]) {
				count=i;
				while (i+1<tree.length&&tree[i+1]==tree[i]) {
					i++;
				}
				i++;
				count = i-count;
				fCount[j]+=count;
				j++;
				if(j==2)
					j=0;
			}
			if(fCount[0]+fCount[1]>max)
				max = fCount[0]+fCount[1];
			fruit[0] = fruit[j];
			fCount[0] = count;
		}
        return max;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().totalFruit(new int[] {1,0,1,4,1,4,1,2,3}));
	}
}
/*
904. Fruit Into Baskets
Medium

In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

    Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
    Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.

Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

 

Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].

Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].

Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].

Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.

 

Note:

    1 <= tree.length <= 40000
    0 <= tree[i] < tree.length
 */