package leetCode.problems._118_Pascals_Triangle;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> results = new ArrayList<>(numRows);
        if(numRows==0)
        	return results;
        ArrayList<Integer> newE = new ArrayList<>();
        newE.add(1);
        results.add(new ArrayList<>(newE));
        if(numRows==1)
        	return results;
        newE.add(1);
        results.add(new ArrayList<>(newE));
        if(numRows==2)
        	return results;
        for (int i = 3; i <= numRows; i++) {
        	ArrayList<Integer> result = new ArrayList<>(i);
			for (int j = 0; j <i; j++) {
				if(j==0||j==i-1) 
					result.add(1);
				else 
					result.add(results.get(results.size()-1).get(j-1)+
							results.get(results.size()-1).get(j));
			}
			results.add(result);
		}
        return results;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generate(5));
	}
}
