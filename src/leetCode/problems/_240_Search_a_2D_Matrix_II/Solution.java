package leetCode.problems._240_Search_a_2D_Matrix_II;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int r = matrix.length;
        if (r<1) 
        	return false;
        
        int c = matrix[0].length;
        if(c<1) 
        	return false;
        return searchMatrixUtil(matrix, target, 0, r, 0, c);
    }
    private boolean searchMatrixUtil(int[][] matrix, int target,
    		int rStart,int rEnd,int cStart,int cEnd) {
    	if(rEnd<=rStart||cEnd<=cStart)
    		return false;
    	int cEndNew = rBinarySearch(matrix, rStart, cStart, cEnd, target);
    	
    	if(cEndNew!=cEnd&&matrix[rStart][cEndNew]==target)
    		return true;
    	if(cEndNew == cStart)
    		return false;
    	
    	cEnd = cEndNew;
    	
    	int rStartNew = cBinarySearch(matrix, cEndNew-1, rStart, rEnd, target);
    	if(rStartNew == rEnd)
    		return false;
    	if(matrix[rStartNew][cEndNew-1]==target)
    		return true;
    	rStart = rStartNew;
    	
    	int cStartNew = rBinarySearch(matrix, rEnd-1, cStart, cEnd, target);
    	if(cStartNew==cEnd)
    		return false;
    	if(matrix[rEnd-1][cStartNew]==target)
    		return true;
    	cStart = cStartNew;
    	
    	int rEndNew = cBinarySearch(matrix, cStart, rStart, rEnd, target);
    	
    	if(rEndNew!=rEnd&&matrix[rEndNew][cStart]==target)
    		return true;
    	if(rEndNew==rStart)
    		return false;
    	rEnd = rEndNew;
    	return searchMatrixUtil(matrix, target, rStart, rEnd, cStart, cEnd);
    }
    private int rBinarySearch(int[][] matrix,int rCount,int start,int end,int target) {
    	int result = (start+end)/2;
    	while (end>start) {
    		if(matrix[rCount][result]>target) {
    			end = result;
        		
    		}else if (matrix[rCount][result]<target) {
				start = result+1;
			}else {
				return result;
			}
    		result = (start+end)/2;
		}
    	return end;
    }
    private int cBinarySearch(int[][] matrix,int cCount,int start,int end,int target) {
    	int result = (start+end)/2;
    	while (end>start) {
    		if(matrix[result][cCount]>target) {
    			end = result;
        		
    		}else if (matrix[result][cCount]<target) {
				start = result+1;
			}else {
				return result;
			}
    		result = (start+end)/2;
		}
    	return end;
    }
    public static void main(String[] args) {
    	int[][] matrix = {{-5}};
    	int target = -5;
    	Solution solution = new Solution();
    	System.out.println(solution.searchMatrix(matrix, target));
	}
}
