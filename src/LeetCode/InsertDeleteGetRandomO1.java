package LeetCode;

import java.util.*;

public class InsertDeleteGetRandomO1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> array;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        array = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val, array.size());
            array.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int i = map.get(val);
            if(i < array.size()-1){
                int k2 = array.get(array.size()-1);
                int i2 = map.get(k2);
                map.put(k2, i);
                array.set(i, k2);
            }
            array.remove(array.size()-1);
            map.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(new Random().nextInt(array.size()));
    }
}
