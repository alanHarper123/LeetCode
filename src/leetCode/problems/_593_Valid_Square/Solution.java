package leetCode.problems._593_Valid_Square;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] vetor12 = getVetor(p1, p2);
        int[] vetor34 = getVetor(p3, p4);
        if((vetor12[0]==0&&vetor12[1]==0)||(vetor34[0]==0&&vetor34[1]==0)) {
        	return false;
        }
        if(vetor12[0]==vetor34[0]&&vetor12[1]==vetor34[1]) {
        	vetor12 = getVetor(p1, p4);
        	vetor34 = getVetor(p2, p3);
        	return isRightAngleAndLength(vetor12, vetor34)&&checkMidPoint(p1, p4, p2, p3);
        }else if(vetor12[0]==-vetor34[0]&&vetor12[1]==-vetor34[1]) {
        	vetor12 = getVetor(p1, p3);
        	vetor34 = getVetor(p2, p4);
        	return isRightAngleAndLength(vetor12, vetor34)&&checkMidPoint(p1, p3, p2, p4);
        }else if(isRightAngleAndLength(vetor12, vetor34)) {
        	return checkMidPoint(p1, p2, p3, p4);
        }
        return false;
    }
    private int[] getVetor(int[] p1, int[] p2) {
    	return new int[] {p2[0]-p1[0],p2[1]-p1[1]};
    }
    private boolean checkMidPoint(int[] p1, int[] p2, int[] p3, int[] p4) {
    	return p1[0]+p2[0]==p3[0]+p4[0]&&p1[1]+p2[1]==p3[1]+p4[1];
    }
    private boolean isRightAngleAndLength(int[] v1, int[] v2) {
    	return v1[0]*v2[0]+v1[1]*v2[1]==0&&v1[0]*v1[0]+v1[1]*v1[1]==v2[0]*v2[0]+v2[1]*v2[1];
    }
}
