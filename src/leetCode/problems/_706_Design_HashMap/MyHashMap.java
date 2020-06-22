package leetCode.problems._706_Design_HashMap;

import java.util.Arrays;

public class MyHashMap {
	private Integer[] map = new Integer[100];
	/** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(key>=map.length) {
        	map = Arrays.copyOf(map, key*2);
        }
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key>=map.length||map[key]==null) {
        	return -1;
        }
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	if(key<map.length) {
    		map[key]=null;
    	}
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
