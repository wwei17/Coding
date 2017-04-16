package LeetCode;

import java.util.*;

public class FlattenNestedListIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
class NestedIterator implements Iterator<Integer> {
    
    List<Integer> list;
    int curr;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList();
        Stack<NestedInteger> st = new Stack<NestedInteger>();
        for(int i = nestedList.size()-1; i >=0 ; i--){
            st.push(nestedList.get(i));
        }
        List<NestedInteger> temp_list = null;
        NestedInteger temp = null;
        while(st.size()>0){
            temp = st.pop();
            if(temp.isInteger()){
                list.add(temp.getInteger());
            }else{
                temp_list = temp.getList();
                for(int i = temp_list.size()-1; i >=0 ; i--){
                    st.push(temp_list.get(i));
                }
            }
        }
        curr = 0;
    }

    @Override
    public Integer next() {
        int res = list.get(curr);
        curr++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return curr<list.size();
    }
}