package leetCode.problems._427_Construct_Quad_Tree;


//Definition for a QuadTree node.
class Node {
	public boolean val;
	public boolean isLeaf;
	public Node topLeft;
	public Node topRight;
	public Node bottomLeft;
	public Node bottomRight;


	public Node() {
		this.val = false;
		this.isLeaf = false;
		this.topLeft = null;
		this.topRight = null;
		this.bottomLeft = null;
		this.bottomRight = null;
	}

	public Node(boolean val, boolean isLeaf) {
		this.val = val;
		this.isLeaf = isLeaf;
		this.topLeft = null;
		this.topRight = null;
		this.bottomLeft = null;
		this.bottomRight = null;
	}

	public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
		this.val = val;
		this.isLeaf = isLeaf;
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
};


public class Solution {
	public Node construct(int[][] grid) {
		if(grid==null||grid.length==0)
			return null;
		int n = grid.length/2;
		Node[][] frontiers = new Node[n][n];
		
		int k = 1;
		if(n==0) {
			Node root = new Node();
			root.isLeaf=true;
			root.val = grid[0][0]==1;
			return root;
		}
		for (int i = n-1; i >=0; i--) {
			for (int j = n-1; j >=0; j--) {
				Node temp = new Node();
				int count = grid[2*i][2*j]+grid[2*i][2*j+1]+grid[2*i+1][2*j]+grid[2*i+1][2*j+1];
				if(count!=0&&count!=4) {
					temp.topLeft=new Node(grid[2*i][2*j]==1,true);
					temp.topRight =new Node(grid[2*i][2*j+1]==1,true);
					temp.bottomLeft =new Node(grid[2*i+1][2*j]==1,true);
					temp.bottomRight = new Node(grid[2*i+1][2*j+1]==1,true);
				}else {
					temp.isLeaf=true;
					temp.val = grid[2*i][2*j]==1;
				}
				frontiers[i][j] = temp;
			}
		}
		while (n>1) {
			n>>=1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Node temp = new Node();
					Node topLeft = frontiers[2*i][2*j];
					Node topRight = frontiers[2*i][2*j+1];
					Node bottomLeft = frontiers[2*i+1][2*j];
					Node bottomRight = frontiers[2*i+1][2*j+1];
					if(topLeft.isLeaf&&topRight.isLeaf&&
							bottomLeft.isLeaf&&bottomRight.isLeaf&&
							topLeft.val==topRight.val&&
									topRight.val==bottomLeft.val&&
											bottomLeft.val==bottomRight.val) {
						temp.isLeaf=true;
						temp.val = topLeft.val;
					}else {
						temp.topLeft=topLeft;
						temp.topRight=topRight;
						temp.bottomLeft=bottomLeft;
						temp.bottomRight=bottomRight;
						
					}
					frontiers[i][j] = temp;
				}
			}
		}
		return frontiers[0][0];
	}
}
