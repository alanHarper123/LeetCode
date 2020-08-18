package leetCode.problems._947_Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.HashSet;

public class Solution {
	class Node {
		Node parent;
	}
    public int removeStones(int[][] stones) {
        Node[] rows = new Node[10000];
        Node[] cols = new Node[10000];
        int unique = 0;
        for(int[]stone:stones) {
        	Node r = rows[stone[0]];
        	Node c = cols[stone[1]];
        	if(r==null) {
        		Node newN = new Node();
        		rows[stone[0]] = newN;
        		if(c==null) {
        			cols[stone[1]] = newN;
        			unique++;
        		}	
        		else 
        			newN.parent = getParent(c);
        	}else {
        		if(c==null) {
        			Node newN = new Node();
        			newN.parent = getParent(r);
        			cols[stone[1]] = newN;
        		}else {
        			Node rP = getParent(r);
        			Node cP = getParent(c);
        			if(rP!=cP) {
        				rP.parent = cP;
        				unique--;
        			}
        		}
        	}
        }
        return stones.length - unique;
    }
    private Node getParent(Node node) {
    	if(node.parent==null)
    		return node;
    	else 
			node.parent = getParent(node.parent);
    	return node.parent;
		
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().removeStones(new int[][] {{0,1},{1,0}}));
	}
}
/*
947. Most Stones Removed with Same Row or Column
Medium

On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5

Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3

Example 3:

Input: stones = [[0,0]]
Output: 0

 

Note:

    1 <= stones.length <= 1000
    0 <= stones[i][j] < 10000
 */