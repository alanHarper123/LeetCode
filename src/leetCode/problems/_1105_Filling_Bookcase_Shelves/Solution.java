package leetCode.problems._1105_Filling_Bookcase_Shelves;

public class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[][] dp = new int[books.length+1][books.length+1];
        return calculate(books,dp, 0, books.length, shelf_width);
    }
    private int calculate(int[][] books,int[][] dp,int i, int j, int shelf_width) {
    	int min = dp[i][j];
    	if(min==0) {
    		min = Integer.MAX_VALUE;
    		int width = books[i][0];
    		int height = 0;
    		int lineH = books[i][1];
    		boolean largerThan_S_W = false;
    		for (int k = i+1,heightKd; k < j; k++) {
				heightKd = calculate(books,dp, i, k, shelf_width)
						+calculate(books,dp, k, j, shelf_width);
				if(heightKd<min)
					min = heightKd;
				width+=books[k][0];
				if(width>shelf_width) {
					largerThan_S_W = true;
					break;
				}
			}
    		if(!largerThan_S_W) {
    			width = books[i][0];
        		for (int k = i+1; k < j; k++) {
    				width+=books[k][0];
    				if(width>shelf_width) {
    					height+=lineH;
    					width = books[k][0];
    					lineH = books[k][1];
    				}else 
    					lineH = Math.max(lineH,books[k][1]);
    			}
        		height+=lineH;
        		if(height<min)
        			min = height;
    		}
    		dp[i][j] = min;
    	}
    	return min;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().minHeightShelves(new int[][] {{2,7},{9,1},{6,1},{4,2},{3,3},{8,6},{10,3},{1,10}}, 10));
	}
}
/*
1105. Filling Bookcase Shelves
Medium

We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].

We want to place these books in order onto bookcase shelves that have total width shelf_width.

We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width), then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down.  We repeat this process until there are no more books to place.

Note again that at each step of the above process, the order of the books we place is the same order as the given sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.

Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

 

Example 1:

Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
Output: 6
Explanation:
The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
Notice that book number 2 does not have to be on the first shelf.

 

Constraints:

    1 <= books.length <= 1000
    1 <= books[i][0] <= shelf_width <= 1000
    1 <= books[i][1] <= 1000

*/