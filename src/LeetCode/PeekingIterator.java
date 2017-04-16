package LeetCode;

import java.util.Iterator;

public class PeekingIterator {

    Integer p;
    Iterator<Integer> it;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    p = it.hasNext()? it.next():null;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return p;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
	    
	    Integer t = p;
	    if(it.hasNext()){ 
	        p = it.next();
	    }else{
	        p = null;
	    }
	    return t;
	}

	public boolean hasNext() {
	    return p!=null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
