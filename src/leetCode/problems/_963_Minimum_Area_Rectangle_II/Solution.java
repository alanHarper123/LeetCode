package leetCode.problems._963_Minimum_Area_Rectangle_II;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public double minAreaFreeRect(int[][] points) {
        double min = Double.MAX_VALUE;
        double area;
        int[] p1,p2,p3,dV1,dV2;
        p3 = new int[2];
        dV1 = new int[2];
        dV2	= new int[2];
        
        ArrayList<Integer> p4;
        p4 =  new ArrayList<>(2);
        p4.add(0);
        p4.add(0);
        
        HashSet<ArrayList<Integer>> pSet = new HashSet<>();
        ArrayList<Integer> p;
        for (int[] point:points) {
        	p = new ArrayList<>(2);
        	p.add(point[0]);
        	p.add(point[1]);
			pSet.add(p);
		}
        for (int i = 0; i < points.length-2; i++) {
        	p1 = points[i];
			for (int j = i+1; j < points.length-1; j++) {
				p2 = points[j];
				dV1[0] = p2[0]-p1[0];
				dV1[1] = p2[1]-p1[1];
				for (int k = j+1; k < points.length; k++) {
					p3 = points[k];
					dV2[0] = p3[0]-p1[0];
					dV2[1] = p3[1]-p1[1];
					if(dV1[0]*dV2[0]+dV1[1]*dV2[1]==0) {
						area = calArea(dV1, dV2);
						if(area<min) {
							p4.set(0, p2[0]+dV2[0]);
							p4.set(1, p2[1]+dV2[1]);
							if(pSet.contains(p4))
								min = area;
						}
					}
				}

			}
		}
        return min==Double.MAX_VALUE?0:min;
    }
    private double calArea(int [] dV1,int [] dV2) {
    	return Math.sqrt(dV1[0]*dV1[0]+dV1[1]*dV1[1])*Math.sqrt(dV2[0]*dV2[0]+dV2[1]*dV2[1]);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().minAreaFreeRect(new int[][] {{1,2},{2,1},{1,0},{0,1}}));
	}
}
