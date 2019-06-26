package leetCode.problems.Integer_to_Roman_12;

import java.util.HashMap;

class Solution {
	private final HashMap<Integer,String> data = new HashMap<>(15);
	public Solution() {
		data.put(1,"I");
		data.put(5,"V");
		data.put(10,"X");
		data.put(50,"L");
		data.put(100,"C");
		data.put(500,"D");
		data.put(1000,"M");
	}

    public String intToRoman(int num) {
    	String result = "";
    	int index = 1;
    	int reminder;
        while(num!=0) {
        	reminder = num%10;
        	if(reminder==4||reminder==9) {
        		result=data.get((reminder+1)*index)+result;
        		result=data.get(index)+result;
        		
        	}else {
        		
        		String temp = data.get(index);
        		for(int i=0; i<reminder%5; i++ ) {
        			result= temp.concat(result);
        		}
        		if(reminder-5>=0) {
        			result=data.get(index*5)+result;
        		}
        	}
        	num /= 10;
        	index *= 10;
        }
        return result;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(3));
		System.out.println("123".substring(0, 0).toCharArray());
	}
}
