package leetCode.problems._497_Random_Point_in_Non_overlapping_Rectangles;

import java.util.Random;

public class Solution {
	private double[] stages;
	private int[][] rects;
	private Random rand = new Random(System.currentTimeMillis());
    public Solution(int[][] rects) {
    	this.rects = rects;
        stages = new double[rects.length];
        double sum = 0;
        for (int i = 0; i < rects.length; i++) {
			sum+=(rects[i][2]-rects[i][0]+1)*(rects[i][3]-rects[i][1]+1);
		}
        double sumi = 0;
        for (int i = 0; i < rects.length; i++) {
			sumi +=(rects[i][2]-rects[i][0]+1)*(rects[i][3]-rects[i][1]+1);
			stages[i] = sumi/sum;
		}
    }
    
    public int[] pick() {
        int[] randRect = rects[pickStage(rand.nextDouble())];
        int[] pick = new int[2];
        pick[0] = randRect[0]+rand.nextInt(randRect[2]-randRect[0]+1);
        pick[1] = randRect[1]+rand.nextInt(randRect[3]-randRect[1]+1);
        return pick;
    }
    private int pickStage(double random) {
    	int start = 0, end = stages.length;
    	while (start!=end) {
			int mid = start+(end-start)/2;
			if(stages[mid]>random)
				end = mid;
			else if(stages[mid]<random)
				start=mid+1;	
			else
				return start;
		}
    	return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
