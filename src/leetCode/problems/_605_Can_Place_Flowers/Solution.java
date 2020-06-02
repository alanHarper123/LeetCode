package leetCode.problems._605_Can_Place_Flowers;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int maxFlC = flowerbed.length/2+(flowerbed.length&1);
        if(n>maxFlC)
        	return false;
        int i = 0;
        for (; i < flowerbed.length; i++) {
			if(flowerbed[i]==1)
				break;
		}
        maxFlC = i/2;
        if(i==flowerbed.length)
        	maxFlC+=(i&1);
        i++;
        for (; i < flowerbed.length;i+=2) {
			if(flowerbed[i]==0) {
				if(i+1==flowerbed.length||flowerbed[i+1]==0) {
					maxFlC++;
				}else {
					i+=1;
				}
			}
		}
        return n<=maxFlC;
        
    }
}
