package leetCode.problems._475_Heaters;

import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int rad = 0;
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int hoursei = 0;
        int heateri = 0;
        for (; hoursei < houses.length; hoursei++) {
			if(houses[hoursei]<=heaters[heateri]) {
				if(heateri==0)
					rad = heaters[heateri]-houses[0];
				else {
					int radi = Math.min(heaters[heateri]-houses[hoursei],
							houses[hoursei]-heaters[heateri-1]);
					rad = Math.max(rad, radi);
				}
			}else {
				heateri++;
				while (heateri<heaters.length&&houses[hoursei]>heaters[heateri]) {
					heateri++;
				}
				if(heateri==heaters.length) {
					rad = Math.max(rad, houses[houses.length-1]-heaters[heateri-1]);
					return rad;
				}
				hoursei--;
			}
		}
        return rad;
        
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findRadius(new int[] {1,2,3,4}, new int[] {1,4}));
		int[] houses = new int[] {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int[] heaters = new int[] {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		System.out.println(solution.findRadius(houses, heaters));
	}
}
