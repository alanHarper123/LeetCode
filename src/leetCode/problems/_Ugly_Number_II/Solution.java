package leetCode.problems._Ugly_Number_II;

import java.util.LinkedList;

public class Solution {
	public int nthUglyNumber(int n) {
		LinkedList<Integer> multiple_two = new LinkedList<>();
		LinkedList<Integer> multiple_Three = new LinkedList<>();
		LinkedList<Integer> multiple_five = new LinkedList<>();
		Integer target = 1;
		Integer temp = 0;
		while (n>1) {
			n--;
			if(!target.equals(temp))
				addNewNumbers(target, multiple_two, multiple_Three, multiple_five);
			temp = target;
			if(multiple_two.peekFirst()>multiple_Three.peekFirst()) {
				if(multiple_five.peekFirst()>multiple_Three.peekFirst()) {
					target = multiple_Three.pollFirst();
				}else {
					target = multiple_five.pollFirst();
				}
			}else {
				if(multiple_five.peekFirst()>multiple_two.peekFirst()) {
					target = multiple_two.pollFirst();
				}else {
					target = multiple_five.pollFirst();
				}
			}
			if(target.equals(temp))
				n++;
		}
		return target;
	}
	private void addNewNumbers(Integer num,LinkedList<Integer> multiple_two,
			LinkedList<Integer> multiple_Three,LinkedList<Integer> multiple_five) {
		multiple_two.add(2*num);
		multiple_Three.add(3*num);
		multiple_five.add(5*num);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.nthUglyNumber(10));
	}
}
