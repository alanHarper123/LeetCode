package leetCode.problems._135_Candy;

public class Solution {
    public int candy(int[] ratings) {
    	if(ratings.length==0)
    		return 0;
    	int candyN = 1;
    	int preCandy=1;
    	int chainN=1;
    	int chain0candN = preCandy;

        for (int i = 1; i < ratings.length; i++) {
			if(ratings[i]>ratings[i-1]) {
				candyN+=++preCandy;
				chainN = 1;
			}	
			else if(ratings[i]==ratings[i-1]){
				preCandy = 1;
				candyN+=1;
				chainN = 1;

			}else {
				if(chainN==1) {
					chain0candN = preCandy;
				}
				if(preCandy==1) {
					candyN+=chainN;
					if(chain0candN<=chainN) {
						candyN++;
						chain0candN++;
					}
						
				}else {
					preCandy=1;
					candyN+=1;
				}
				chainN++;
			}
	
		}
        return candyN;
    }
    public static void main(String[] args) {
		int[][] tests = {
				{1,2,3,1,0},
				{1,0,2},{1,2,2},{1,2,87,87,87,2,1},{1,3,4,5,2},
				
		};
		Solution solution = new Solution();
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.candy(tests[i]));
		}
	}
}
