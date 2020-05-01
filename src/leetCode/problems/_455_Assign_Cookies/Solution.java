package leetCode.problems._455_Assign_Cookies;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null||s.length==0||g.length==0)
        	return 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int gi=g.length-1,si=s.length-1,count=0;
        while (gi>=0&&si>=0) {
			if(s[si]>=g[gi]) {
				count++;
				si--;
				gi--;
			}else {
				gi--;
				while (gi>=0&&s[si]<g[gi]) {
					gi--;
				}
			}
		}
        return count;
    }
}
