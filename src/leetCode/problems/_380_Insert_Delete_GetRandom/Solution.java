package leetCode.problems._380_Insert_Delete_GetRandom;

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
	private int count;
	private Random rand = new Random(System.currentTimeMillis());
	private HashMap<Integer, Integer> keyToValueMap;
	private HashMap<Integer, Integer> valueToKeyMap;
	/** Initialize your data structure here. */
	public RandomizedSet() {
		keyToValueMap = new HashMap<>();
		valueToKeyMap = new HashMap<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(!valueToKeyMap.containsKey(val)) {
			keyToValueMap.put(count, val);
			valueToKeyMap.put(val, count);
			count++;
			return true;
		}
		return false;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		Integer index = valueToKeyMap.get(val);
		if(index==null) {
			return false;
		}else {
			count--;
			int tempval = keyToValueMap.get(count);
			keyToValueMap.remove(count);
			valueToKeyMap.remove(val);
			if(index!=count) {
				keyToValueMap.put(index, tempval);
				valueToKeyMap.put(tempval, index);
			}
		}
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return keyToValueMap.get(rand.nextInt(count));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
