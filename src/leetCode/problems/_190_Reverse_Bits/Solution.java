package leetCode.problems._190_Reverse_Bits;

public class Solution {
    // you need treat n as an unsigned value
//    public int reverseBits(int n) {
//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//			if((n&(1<<i))!=0)
//				result+=1<<(31-i);
//		}
//        return result;
//    }
    public int reverseBits(int n) {
        int result = 0;
        int l = 1;
        
		if((n&l)!=0)
			result+=1<<31;
		l=l<<1;
		int h = 1<<30;
        for (int i = 0; i < 31; i++,l=l<<1,h=h>>1) {
			if((n&l)!=0)
				result+=h;
		}
        return result;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(solution.reverseBits(2)));
	}
}
