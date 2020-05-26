package leetCode.problems._554_Brick_Wall;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
    	Iterator<Integer>[] iters = new Iterator[wall.size()];
    	int i=0;
    	for (List<Integer> list:wall) {
			iters[i++] = list.iterator();
		}
    	HashMap<Integer, Integer> map=new HashMap<>();
    	int max = 0;
    	for (int j = 0; j < iters.length; j++) {
			int sum = 0;
			while (true) {
				sum+=iters[j].next();
				if(iters[j].hasNext()) {
					int countj = map.getOrDefault(sum, 0);
					countj++;
					if(countj>max)
						max=countj;
					map.put(sum, countj);
				}else
					break;
			}
		}
    	return wall.size() - max;
    }
}
