package leetCode.problems._341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.List;


//* // This is the interface that allows for creating nested lists.
//* // You should not implement it, or speculate about its implementation
interface NestedInteger {
	//*
	//*     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();
	//*
	//*     // @return the single integer that this NestedInteger holds, if it holds a single integer
	// *     // Return null if this NestedInteger holds a nested list
	public Integer getInteger();
	//*
	// *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	// *     // Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
	private List<NestedInteger> nestedList;
	private int count;
	private NestedIterator currentnestedList;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.nestedList = nestedList;
		count = 0;
		currentnestedList = null;
		if(this.nestedList!=null&&nestedList.size()>0) {
			findValidCount();
		}
			
	}
	private void findValidCount() {
		while (count<nestedList.size()) {
			if(nestedList.get(count).isInteger()) {
				currentnestedList = null;
			    break;
			}
			else {
				currentnestedList = new NestedIterator(nestedList.get(count).getList());
				if(currentnestedList.hasNext())
					break;
			}
			count++;
		}
	}

	@Override
	public Integer next() {
		Integer result = null;
		if(currentnestedList==null) {
			result = nestedList.get(count).getInteger();
			count++;
			findValidCount();
		}else {
			result = currentnestedList.next();
			if(!currentnestedList.hasNext()) {
				count++;
				findValidCount();
			}
		}
		return result;	
			
	}

	@Override
	public boolean hasNext() {
		
		return nestedList!=null&&count<nestedList.size();
		

	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
