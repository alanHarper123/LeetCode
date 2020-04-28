//package leetCode.problems._385_miniParser;
//
//import java.util.List;
//
//// This is the interface that allows for creating nested lists.
// // You should not implement it, or speculate about its implementation
//interface NestedInteger {
//     // Constructor initializes an empty nested list.
//     public NestedInteger();
//
//     // Constructor initializes a single integer.
//     public NestedInteger(int value);
//
//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();
//
//     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     // Return null if this NestedInteger holds a nested list
//     public Integer getInteger();
//
//     // Set this NestedInteger to hold a single integer.
//     public void setInteger(int value);
//
//     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//     public void add(NestedInteger ni);
//
//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     // Return null if this NestedInteger holds a single integer
//     public List<NestedInteger> getList();
// }
//
//public class Solution {
//    public NestedInteger deserialize(String s) {
//    	NestedInteger result = new  NestedInteger();
//    	if(s.startsWith("[")) {
//    		if(s.indexOf(",")==-1) {
//                if(1!=s.length()-1) 
//                    result.add(deserialize(s.substring(1,s.length()-1)));
//    		}else {
//    			int leftBC = 0;
//    			int left = 1;
//    			int i = 1;
//    			for (; i < s.length(); i++) {
//					if(s.charAt(i)==',') {
//						if(leftBC==0) {
//							result.add(deserialize(s.substring(left, i)));
//							left = i+1;
//						}
//					}else if(s.charAt(i)=='[')
//						leftBC++;
//					else if(s.charAt(i)==']')
//						leftBC--;	
//				}
//    			if(left!=i-1)
//    				result.add(deserialize(s.substring(left, i-1)));  
//    		}
//    	}else {
//    		result.setInteger(Integer.valueOf(s));
//    	}
//        return result;
//    }
//}
