package leetCode.problems._1146_Snapshot_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SnapshotArray {
	int snapC = 0;
	int setId = 0;
	HashMap<Integer, Integer> snapToSet = new HashMap<>();
	ArrayList<int[]>[] data;
	Comparator<int[]> comparator = new Comparator<int[]>() {
		public int compare(int[] a1, int[] a2) {
			return a1[0] -a2[0];
		}
	};
    public SnapshotArray(int length) {
        data = new ArrayList[length];
        for (int i = 0; i < data.length; i++) {
			data[i] = new ArrayList<>();
		}
    }
    
    public void set(int index, int val) {
        data[index].add(new int[] {setId++,val});
    }
    
    public int snap() {
    	snapToSet.put(snapC, setId);
        return snapC++;
    }
    
    public int get(int index, int snap_id) {
        int setIdNew = snapToSet.get(snap_id);
        int indexNew = Collections.binarySearch(data[index], new int[] {setIdNew}, comparator);
        if(indexNew<0)
        	indexNew = -(indexNew+1);
        indexNew--;
        if(indexNew<0)
        	return 0;
        else 
			return data[index].get(indexNew)[1];
    }
}
/*
1146. Snapshot Array
Medium

Implement a SnapshotArray that supports the following interface:

    SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
    void set(index, val) sets the element at the given index to be equal to val.
    int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
    int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id

 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5

 

Constraints:

    1 <= length <= 50000
    At most 50000 calls will be made to set, snap, and get.
    0 <= index < length
    0 <= snap_id < (the total number of times we call snap())
    0 <= val <= 10^9

*/