package leetCode.problems._685_Redundant_Connection_II;

public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        int[] trueParents = new int[edges.length+1];
        int[] edge1=null;
        int[] edge2=null;
        int[] roundEdge=null;
        boolean isCircle = false;
        for(int[] edge:edges) {
        	if(trueParents[edge[1]]!=0) {
        		edge1 = new int[] {trueParents[edge[1]],edge[1]};
        		edge2 = edge;
        		continue;
        	}
        	if(!isCircle) {
        		trueParents[edge[1]] = edge[0];
            	int u = findParent(parents, edge[0]);
            	int v = findParent(parents, edge[1]);
            	if(u==v) {
            		roundEdge = edge;
            		isCircle = true;
            	}	
            	parents[u]=v;
        	}
        }
        if(roundEdge==null) {
        	return edge2;
        }else {
        	return edge1==null?roundEdge:edge1;
        }
    }
    private int findParent(int[] parents,int x) {
    	if(parents[x]==0)
    		return x;
    	parents[x] = findParent(parents, parents[x]);
    	return parents[x];
    }
}
