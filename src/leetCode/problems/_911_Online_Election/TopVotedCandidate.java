package leetCode.problems._911_Online_Election;

public class TopVotedCandidate {
	private int[] leadingPerson;
	private int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        int[] voteC = new int[persons.length+1];
        leadingPerson = new int[times.length]; 
        this.times = times;
        int maxC=0,p=0;
        for (int i = 0,pi; i < times.length; i++) {
        	pi = persons[i];
			voteC[pi]++;
			if(voteC[pi]>=maxC) {
				maxC = voteC[pi];
				p = pi;
			}
			leadingPerson[i] = p;
		}
    }
    
    public int q(int t) {
        if(t>=times[times.length-1])
        	return leadingPerson[leadingPerson.length-1];
        int start = 0,end = times.length,mid;
        while (end>start) {
			mid = start+(end-start)/2;
			if(times[mid]>t)
				end = mid;
			else if(times[mid]<t)
				start = mid+1;
			else 
				return leadingPerson[mid];
		}
        return leadingPerson[start-1];
    }
}
/*
911. Online Election
Medium

In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.  

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

 

Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation: 
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.

 

Note:

    1 <= persons.length = times.length <= 5000
    0 <= persons[i] <= persons.length
    times is a strictly increasing array with all elements in [0, 10^9].
    TopVotedCandidate.q is called at most 10000 times per test case.
    TopVotedCandidate.q(int t) is always called with t >= times[0].
 */