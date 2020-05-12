package leetCode.problems._Flood_Fill;

public class Solution {
	private final int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	if(newColor!=image[sr][sc])
    		dfsFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfsFill(int[][] image, int sr, int sc,int oldColor, int newColor) {
    	if(image[sr][sc]!=oldColor)
    		return;
    	else 
    		image[sr][sc]=newColor;
    	for (int[] dir:dirs) {
			int newR = sr+dir[0];
			int newC = sc+dir[1];
			if(newR<image.length&&newR>=0&&newC>=0
					&&newC<image[0].length&&image[newR][newC]==oldColor)
				dfsFill(image, newR, newC, oldColor, newColor);
		}
		
    }
}
