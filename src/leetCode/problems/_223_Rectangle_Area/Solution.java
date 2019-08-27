package leetCode.problems._223_Rectangle_Area;

class Solution {
    public int computeArea(int A, int B, int C,int D,
    		               int E, int F, int G, int H) {
    	int sumA = (C-A)*(D-B)+(G-E)*(H-F);
    	if(A>=G||B>=H||C<=E||D<=F)
    		return sumA;
    	else {
    		int deltaW = Math.min(C, G)-Math.max(A, E);
    		int deltaH = Math.min(D, H)-Math.max(B, F);
    		return sumA-deltaH*deltaW;
    	} 
    }
}
