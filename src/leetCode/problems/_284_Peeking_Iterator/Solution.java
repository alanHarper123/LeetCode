package leetCode.problems._284_Peeking_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	private LinkedList<Integer> base;
	private ListIterator<Integer> listIterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		base = new LinkedList<>();
	    for (Iterator iterator2 = iterator; iterator2.hasNext();) {
			Integer integer = (Integer) iterator2.next();
			base.add(integer);
		}
	    listIterator = base.listIterator();
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		Integer result = listIterator.next();
		listIterator.previous();
		return result;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return listIterator.next();
	}

	@Override
	public boolean hasNext() {
	    return listIterator.hasNext();
	}
}
