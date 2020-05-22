package leetCode.problems._547_Friend_Circles;

public class Solution {
    public int findCircleNum(int[][] M) {
    	if(M==null||M.length==0)
    		return 0;
        //DFS
    	int count = 0;
    	int colC = M[0].length;
    	boolean[] isRowVisited = new boolean[M.length];
    	loop1:for (int i = 0; i < M.length; i++) {
    		if(isRowVisited[i])
    			continue;
			for (int j = 0; j < colC; j++) {
				if(M[i][j]==1) {
					count++;
					dfs(M, i,j, colC, isRowVisited);
					continue loop1;
				}
			}
		}
    	return count;
    }
    private void dfs(int[][] M,int i,int j,int colC,boolean[] isRowVisited) {
    	isRowVisited[i]=true;
    	for (int k = j; k < colC; k++) {
			if(M[i][k]==1) {
				M[i][k] = 0;
				if(isRowVisited[k]==false)
					dfs(M, k,0, colC, isRowVisited);
			}
		}
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] test = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution.findCircleNum(test));
	}
    
}
