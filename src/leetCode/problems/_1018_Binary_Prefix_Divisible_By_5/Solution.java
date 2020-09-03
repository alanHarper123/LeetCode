package leetCode.problems._1018_Binary_Prefix_Divisible_By_5;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int remainder = 0;
        LinkedList<Boolean> res = new LinkedList<>();
        int i = 0;
        for(int e:A) {
        	remainder+=e;
        	remainder%=5;
        	res.add(remainder==0);
        	remainder<<=1;
        }
        return res;
    }
}
