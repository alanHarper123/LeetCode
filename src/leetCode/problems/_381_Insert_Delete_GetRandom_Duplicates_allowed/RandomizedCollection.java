package leetCode.problems._381_Insert_Delete_GetRandom_Duplicates_allowed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedCollection {
	private int count=0;
	private Random rand = new Random(System.currentTimeMillis());
	private HashMap<Integer, Integer> keyToValueMap = new HashMap<>();;
	private HashMap<Integer, HashSet<Integer>> valueToKeyMap = new HashMap<>();;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	HashSet<Integer> indexes = valueToKeyMap.get(val);
        if(indexes==null) {
        	indexes = new HashSet<>();
        	valueToKeyMap.put(val, indexes);
        }
    	indexes.add(count++);
    	keyToValueMap.put(count-1, val);
    	return indexes.size()==1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	HashSet<Integer> indexes = valueToKeyMap.get(val);
    	if(indexes==null) {
    		return false;
    	}
    	if(indexes.size()==0)
    		return false;
    	
    	count--;
		Integer tempVal = keyToValueMap.get(count);
		if(tempVal==val) {
			indexes.remove(count);
		}else {
			int firstindex = indexes.iterator().next();
			indexes.remove(firstindex);
			keyToValueMap.put(firstindex, tempVal);
			HashSet<Integer> alIndexes = valueToKeyMap.get(tempVal);
			alIndexes.remove(count);
			alIndexes.add(firstindex);
		}
		
    	return true;	
    	
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return keyToValueMap.get(rand.nextInt(count));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
