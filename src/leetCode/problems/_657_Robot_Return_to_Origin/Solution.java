package leetCode.problems._657_Robot_Return_to_Origin;

public class Solution {
	public boolean judgeCircle(String moves) {
		int detaX = 0;
		int detaY = 0;
		for (int i = moves.length()-1; i >=0 ; i--) {
			switch (moves.charAt(i)) {
			case 'U':
				detaY++;
				break;
			case 'D':
				detaY--;
				break;
			case 'R':
				detaX++;
				break;
			default:
				detaX--;
				break;
			}
		}
		return detaX==0&&detaY==0;
	}
}
