package leetCode.problems._492_Construct_the_Rectangle;

public class Solution {
    public int[] constructRectangle(int area) {
        int l = (int)Math.sqrt(area);
        for (int i = l; i >=1; i--) {
			if(area%i==0)
				return new int[] {area/i,i};
		}
        return new int[] {0,0};
    }
}
