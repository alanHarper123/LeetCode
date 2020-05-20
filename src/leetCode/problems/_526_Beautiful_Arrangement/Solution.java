package leetCode.problems._526_Beautiful_Arrangement;

public class Solution {
	int count;
    public int countArrangement(int N) {
    	count = 0;
        boolean[] isOccupied = new boolean[N+1];
        backTrack(N, isOccupied, N);
        return count;
    }
    private void backTrack(int k,boolean[] isOccupied,int N) {
    	if(k<1) {
    		count++;
    		return;
    	}
    		
    	for (int i = 1; i <= k; i++) {
			if(k%i==0&&isOccupied[i]==false) {
				isOccupied[i] = true;
				backTrack(k-1, isOccupied, N);
				isOccupied[i] = false;
			}
		}
    	int i=2;
    	while (i*k<=N) {
			if(isOccupied[i*k]==false) {
				isOccupied[i*k] = true;
				backTrack(k-1, isOccupied, N);
				isOccupied[i*k] = false;
			}
			i++;
		}
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countArrangement(2));
	}
}
