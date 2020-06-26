package leetCode.problems._735_Asteroid_Collision;

import java.util.LinkedList;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> preA = new LinkedList<>();
        for (int asteroid:asteroids) {
			if(preA.isEmpty()||asteroid>0)
				preA.add(asteroid);
			else {
				if(preA.peekLast()<0) {
					preA.add(asteroid);
				}else {
					while (!preA.isEmpty()&&preA.peekLast()>0&&preA.peekLast()<-asteroid) {
						preA.pollLast();
					}
					if(preA.isEmpty()||preA.peekLast()<0)
						preA.add(asteroid);
					else if(preA.peekLast()==-asteroid) {
						preA.pollLast();
					}
				}
			}
		}
        int[] survivors = new int[preA.size()] ;
        for (int i = 0; i < survivors.length; i++) {
        	survivors[i] = preA.pollFirst();
		}
        return survivors;
    }
}
