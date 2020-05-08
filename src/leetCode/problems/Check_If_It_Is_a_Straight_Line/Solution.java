package leetCode.problems.Check_If_It_Is_a_Straight_Line;

public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2)
        	return true;
        if(coordinates[0][0]==coordinates[1][0]) {
        	for (int i = 2; i < coordinates.length; i++) {
				if(coordinates[2][0]!=coordinates[0][0])
					return false;
			}
        	return true;
        }
        int baseX = coordinates[0][0];
        int baseY = coordinates[0][1];
        double scale =(double)(coordinates[1][1]-coordinates[0][1])
        		/(double)(coordinates[1][0]-coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
			int y = baseY+(int)((coordinates[i][0]-coordinates[0][0])*scale);
			if(y!=coordinates[i][1])
				return false;
		}	
        return true;
    }
}
