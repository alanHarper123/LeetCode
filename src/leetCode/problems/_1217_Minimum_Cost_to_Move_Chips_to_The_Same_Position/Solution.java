package leetCode.problems._1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position;

public class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenC = 0;
        for (int e:position) {
			if((e&1)==0)
				evenC++;
		}
        return Math.min(evenC, position.length-evenC);
    }
}
