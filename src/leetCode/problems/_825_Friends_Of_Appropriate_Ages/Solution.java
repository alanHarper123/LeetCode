package leetCode.problems._825_Friends_Of_Appropriate_Ages;

import java.util.Arrays;

public class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int requestSum = 0;
        int preIndex = 0;
        for (int i = 0; i < ages.length; i++) {
			int equalC = 1;
			while (i+1<ages.length&&ages[i+1]==ages[i]) {
				equalC++;
				i++;
			}
			int limit = ages[i]/2+7;
			while (preIndex<i&&ages[preIndex]<=limit) {
				preIndex++;
			}
			if(preIndex!=i) {
				requestSum+=equalC*(i-preIndex);
			}
		}
        return requestSum;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numFriendRequests(new int[] {109,6,101,18,13,20,106,110,110,108,55,89,81,56,84,37,71,51,88,70,27,16,31,63,99,68,12,120,104,18,110,42,93,106,99,63,3,82,22,17,69,49,88,117,57,37,95,15,50,18,77,103,102,104,87,1,23,97,93,15,9,35,59,103,118,23,52,66,86,7,40,33,60,4,113,43,21,58,31,120,71,56,19,67,68,32,84,14,50,55,98,34,89,32,58,20,93,37,95,40}));
	}
}
/*
825. Friends Of Appropriate Ages
Medium

Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

    age[B] <= 0.5 * age[A] + 7
    age[B] > age[A]
    age[B] > 100 && age[A] < 100

Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.

Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.

Example 3:

Input: [20,30,100,110,120]
Output: 3
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.

 

Notes:

    1 <= ages.length <= 20000.
    1 <= ages[i] <= 120.
 */
