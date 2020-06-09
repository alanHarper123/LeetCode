package leetCode.problems._649_Dota2_Senate;

public class Solution {
	public String predictPartyVictory(String senate) {
		int activeR;
		int magicR=0;
		int activeD;
		int magicD=0;
		String senateR = senate;
		StringBuilder stringBuilder;
		do {
			stringBuilder = new StringBuilder();
			activeR = 0;
			activeD = 0;
			for (int i = 0; i < senateR.length(); i++) {
				char c = senateR.charAt(i);
				if(c=='R') {
					if(magicD>0)
						magicD--;
					else {
						magicR++;
						activeR++;
						stringBuilder.append(c);

					}
				}else {
					if(magicR>0)
						magicR--;
					else {
						magicD++;
						activeD++;
						stringBuilder.append(c);
					}
				}
			}
			senateR = stringBuilder.toString();
		} while (activeR>0&&activeD>0);

		if(activeR>0)
			return "Radiant";
		else 
			return "Dire";

	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.predictPartyVictory("RDD"));
	}
}
