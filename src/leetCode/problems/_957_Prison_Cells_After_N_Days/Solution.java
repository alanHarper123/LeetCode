package leetCode.problems._957_Prison_Cells_After_N_Days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Solution {
	private Random random = new Random(System.currentTimeMillis());
    public int[] prisonAfterNDays(int[] cells, int N) {
    	System.out.println(Arrays.toString(cells));
        int[] next;
        int[] first;
        boolean isEqual;
        ArrayList<int[]> allCells = new ArrayList<>();
        while (N>0) {
        	N--;
        	next = new int[cells.length];
        	for (int i = 1; i < next.length-1; i++) {
				if(cells[i-1]==cells[i+1])
					next[i] = 1;
			}
			cells = next;
			if(!allCells.isEmpty()) {
				isEqual = true;
				first = allCells.get(0);
				for (int i = 0; i < first.length; i++) {
					if(first[i]!=cells[i]) {
						isEqual = false;
						break;
					}	
				}
				if(isEqual) {
					cells = allCells.get(N%allCells.size());
					break;
				}
			}
			allCells.add(cells);
		}
        
        return cells;
    }
    public static void main(String[] args) {
    	int c = 5;
    	int[] cells = new int[8];
    	Solution solution = new Solution();
    	while (c>0) {
			c--;
			System.out.println("_____________________");
			for (int i = 0; i < cells.length; i++) {
				cells[i] = solution.random.nextInt(2);
			}
			solution.prisonAfterNDays(cells, 12);
		}
	}
}
/*
957. Prison Cells After N Days
Medium

There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.

(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]

 

Note:

    cells.length == 8
    cells[i] is in {0, 1}
    1 <= N <= 10^9
*/