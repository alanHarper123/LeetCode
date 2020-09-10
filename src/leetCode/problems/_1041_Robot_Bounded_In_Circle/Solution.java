package leetCode.problems._1041_Robot_Bounded_In_Circle;

public class Solution {
	int [][] dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
    public boolean isRobotBounded(String instructions) {
        int[] p = new int[2];
        int i = 0;
        for (int j = 0; j < instructions.length(); j++) {
			switch (instructions.charAt(j)) {
			case 'G':
				p[0]+=dirs[i][0];
				p[1]+=dirs[i][1];
				break;
			case 'L':
				i++;
				if(i>=dirs.length)
					i=0;
				break;
			default:
				i--;
				if(i<0)
					i=dirs.length-1;
				break;
			}
		}
        int[] newP = new int[2];
        newP[0] = p[0];
        newP[1] = p[1];
        int newi = i;
        while (newi!=0) {
			newi+=i;
			int it = i;
			while (it>0) {
				it--;
				int temp = p[0];
				p[0] = -p[1];
				p[1] = temp;
			}
			if(newi>=dirs.length)
				newi-=dirs.length;
			newP[0] += p[0];
	        newP[1] += p[1];
		}
        return newP[0] == 0&&newP[1] == 0;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isRobotBounded("GL"));
	}
}
/*
1041. Robot Bounded In Circle
Medium

On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degress to the right.

The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Example 2:

Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.

Example 3:

Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...

 

Note:

    1 <= instructions.length <= 100
    instructions[i] is in {'G', 'L', 'R'}

*/