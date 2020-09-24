package leetCode.problems._1103_Distribute_Candies_to_People;

public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int n = num_people;
        int sum = ((1+n)*n)/2;
        int dif = n*n;
        int count = 0;
        while (candies>=sum) {
        	candies-=sum;
			count++;
			sum+=dif;
		}
        if(count!=0) {
        	int first = (((count-1)*n+2)*count)/2;
        	for (int i = 0; i < res.length; i++) {
				res[i] = first;
				first+=count;
			}
        }
        int candi = count*n+1;
        for (int i = 0; candies>0; i++,candi++) {
			if(candies>=candi) {
				res[i]+=candi;
			}else {
				res[i]+=candies;
				break;
			}	
			candies-=candi;
		}
        return res;
    }
}
