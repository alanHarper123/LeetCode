package leetCode.problems._705_Design_HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyHashSet {
	private static final int hashp = 9999;
	private LinkedList<Integer>[] base = new LinkedList[hashp];
    /** Initialize your data structure here. */
    public MyHashSet() {
    }
    
    public void add(int key) {
        int index = key%hashp;
        LinkedList<Integer> list = base[index];
        if(list==null) {
        	list = new LinkedList<Integer>();
        	base[index] = list;
        }
    	ListIterator<Integer> iter = list.listIterator();
    	while (iter.hasNext()) {
			if(iter.next()==key) {
				return;
			}
		}
        list.add(key);
    }
    
    public void remove(int key) {
    	int index = key%hashp;
    	LinkedList<Integer> list = base[index];
        if(list!=null) {
        	ListIterator<Integer> iter = list.listIterator();
        	while (iter.hasNext()) {
				if(iter.next()==key) {
					iter.remove();
					break;
				}
			}
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int index = key%hashp;
    	LinkedList<Integer> list = base[index];
        if(list!=null) {
        	ListIterator<Integer> iter = list.listIterator();
        	while (iter.hasNext()) {
				if(iter.next()==key) {
					return true;
				}
			}
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
