package leetCode.problems._1222_Queens_That_Can_Attack_the_King;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] candidates = new int[8][3];
        for (int [] queen:queens) {
			int dx = queen[0] - king[0];
			int dy = queen[1] - king[1];
			int d =  Math.abs(dx)+Math.abs(dy);
			if(dx==0) {
				if(dy>0) {
					fillCandidates(candidates, 2, d, queen);
				}else {
					fillCandidates(candidates, 6, d, queen);
				}
			}else if(dy==0) {
				if(dx>0) {
					fillCandidates(candidates, 0, d, queen);
				}else {
					fillCandidates(candidates, 4, d, queen);
				}
			}else if(dx>0) {
				if(dy>0&&dx==dy)
					fillCandidates(candidates, 1, d, queen);
				else if(dx==-dy)
					fillCandidates(candidates, 7, d, queen);
			}else {
				if(dy>0&&-dx==dy)
					fillCandidates(candidates, 3, d, queen);
				else if(dx==dy)
					fillCandidates(candidates, 5, d, queen);
			}
		}
        LinkedList<List<Integer>> result = new LinkedList<>();
        for(int[] cand:candidates) {
        	if(cand[2]!=0) {
        		LinkedList<Integer> newE = new LinkedList<>();
        		newE.add(cand[0]);
        		newE.add(cand[1]);
        		result.add(newE);
        	}	
        }
        return result;
    }
    private void fillCandidates(int[][] candidates,int ci,int d,int[] queen) {
    	if(candidates[ci][2]==0||candidates[ci][2]>d) {
    		candidates[ci][0] = queen[0];
    		candidates[ci][1] = queen[1];
    		candidates[ci][2] = d;
    	}
    }
}
