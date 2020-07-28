package leetCode.problems._881_Boats_to_Save_People;

import java.util.Arrays;

class DoubleLinkList{
	DoubleLinkList pre;
	DoubleLinkList next;
	int val;
	public DoubleLinkList(int val) {
		this.val = val;
	}
	void deleteSelf() {
		if(pre!=null)
			pre.next = next;
		if(next!=null)
			next.pre = pre;
	}
}
public class Solution {
    public int numRescueBoats001(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] isBoated = new boolean[people.length];
        int boatNum = 0;
        int i = people.length-1;
        for (; i >=0; i--) {
			if(people[i]!=limit)
				break;
		}
        boatNum+=people.length-i-1;
        int start = 0;
        while (i>=0) {
			if(!isBoated[i]) {
				isBoated[i] = true;
				boatNum++;
				if(i!=0) {
					start = joinBoat(limit-people[i], Math.min(start, i-1), i, people, isBoated);
				}
			}
			i--;
		}
        return boatNum;
    }
    private int joinBoat(int dif, int start,int end, int[] people,boolean[] isBoated) {
    	int pre = -1;
    	for (int i = start; i < end; i++) {
			if(people[i]>dif) {
				break;
			}
			if(!isBoated[i]) {
				pre = i;
			}
		}
    	if(pre!=-1) {
			isBoated[pre] = true;
			return pre;
		}
    	for (int i = start-1; i >=0; i--) {
    		if(!isBoated[i]) {
				isBoated[i] = true;
				return i;
			}
		}
    	return start;
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatNum = 0;
        int i = people.length-1;
        for (; i >=0; i--) {
			if(people[i]!=limit)
				break;
		}
        boatNum+=people.length-i-1;
        if(i>=0) {
        	DoubleLinkList head = new DoubleLinkList(people[0]-1);
        	DoubleLinkList end = head;
        	for (int j = 0; j <= i; j++) {
				DoubleLinkList node = new DoubleLinkList(people[j]);
				node.pre = end;
				end.next = node;
				end = node;
			}
        	DoubleLinkList start = head;
        	while(end!=head) {
        		boatNum++;
        		if(end.pre!=head) {
        			start = jointBoat(head,start.pre==end?end:start, end, limit-end.val);
        		}
        		end = end.pre;
        	}
        }
        return boatNum;
    }
    private DoubleLinkList jointBoat(DoubleLinkList head,DoubleLinkList start,
    		DoubleLinkList end,int dif) {
    	DoubleLinkList pre = start;
    	DoubleLinkList runner = start;
    	if(start.val<=dif) {
    		while (runner!=end&&runner.val<=dif) {
    			pre = runner;
    			runner = runner.next;
			}
    		if(pre!=start) {
    			pre.deleteSelf();
        		return pre;
    		}
    	}
    	pre = start;
    	start = start.pre;
    	if(start==null)
    		return pre;
		while (start!=head&&start.val>dif) {
			pre = start;
			start = start.pre;
		}
		if(start!=head) {
			start.deleteSelf();
			return start;
		}
		return pre;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().numRescueBoats(new int[] {44,10,29,12,49,41,23,5,17,26}, 50));
	}
}
/*
881. Boats to Save People
Medium

The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

Note:

    1 <= people.length <= 50000
    1 <= people[i] <= limit <= 30000
 */
