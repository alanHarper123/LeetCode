package leetCode.problems._728_Self_Dividing_Numbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Byte> digits = new ArrayList<>();
        int leftTemp = left-1;
        while (leftTemp>0) {
        	digits.add((byte)(leftTemp%10));
        	leftTemp/=10;
		}
        
        for (int i = digits.size()-1; i >=0; i--) {
			if(digits.get(i)==0) {
				for (int j = i; j>0; j--) {
					digits.set(j, (byte)1);
				}
				digits.set(0, (byte)0);
				left = 0;
				for (int j = digits.size()-1; j >=0; j--) {
					left*=10;
					left+=digits.get(j);
				}
				left+=1;
				break;
			}
		}
        LinkedList<Integer> result = new LinkedList<>();
        loop1:for (int i = left; i <= right;i++) {
			boolean levelUp = true;
			for (int j = 0; levelUp&&j < digits.size();j++) {
				Byte digit = digits.get(j);
				digit++;
				if(digit==10) {
					digits.set(j, (byte)0);
				}else {
					levelUp = false;
					digits.set(j, digit);
				}
			}
			if(levelUp)
				digits.add((byte)1);
			if(digits.get(0)==0) {
				
				for (int j = 1,pow = 10; j < digits.size()&&digits.get(j)==0; j++) {
					digits.set(j, (byte)1);
					i+=pow;
					pow*=10;
				}
			}else {
				for (int j = 0; j < digits.size(); j++) {
					if(i%digits.get(j)!=0)
						continue loop1;
				}
				result.add(i);
			}
			
		}
        return result;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.selfDividingNumbers(3056,4813));
	}
}
