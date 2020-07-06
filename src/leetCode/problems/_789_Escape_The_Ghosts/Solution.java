package leetCode.problems._789_Escape_The_Ghosts;

public class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distS = Math.abs(target[0])+Math.abs(target[1]);
        for(int[] ghost:ghosts) {
        	if(Math.abs(ghost[0]-target[0])+Math.abs(ghost[1]-target[1])<=distS)
        		return false;
        }
        return true;
    }
}
