package LeetCode;

import java.util.HashMap;

public class AllOoneDataStructure {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllOne a = new AllOne();
		a.inc("a");
		a.inc("b");
		a.inc("b");
		a.inc("b");
		a.inc("b");
		a.dec("b");
		a.dec("b");
		System.out.println(a.getMaxKey());
		System.out.println(a.getMinKey());
	}
}
class AllOne {
    BiNode head;
    BiNode tail;
    HashMap<String, BiNode> map;
    /** Initialize your data structure here. */
    public AllOne() {
        this.map = new HashMap<String, BiNode>();
        this.head = null;
        this.tail = null;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	BiNode b = null;
    	if(!map.containsKey(key)){
    		b = new BiNode(key, 1);
    		map.put(key, b);
    		b.next = head;
    		if(head!=null) head.prev = b;
    		head = b;
    		if(tail == null) tail = b;
    	}else{
    		b = map.get(key);
    		b.val++;
    		if(tail == null || b.val > tail.val){
    			if(b == head) head = b.next;
                b.remove();
                b.prev = tail;
                if(tail != null) tail.next = b;
                tail = b;
                
            }
    	}
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            BiNode b = map.get(key);
            b.val --;
            if(b != head){
                if(b.val < head.val){
                	if(b == tail) tail = b.prev;
                    b.remove();
                }
                if(b.val < 1){
                    map.remove(key);
                } else{
                    b.next = head;
                    if(head != null) head.prev = b;
                    head = b;
                }
            }else{
                if(b.val < 1){
                    map.remove(key);
                    head = head.next;
                    if(head != null) head.prev = null;
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail!=null? tail.key: "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head!=null? head.key: "";
    }
    
    class BiNode{
        BiNode prev;
        BiNode next;
        int val;
        String key;
        BiNode(String k, int v){
            this.key = k;
            this.val = v;
            prev = null;
            next = null;
        }
        
        public void remove(){
            if(next != null) next.prev = prev;
            if(prev != null) prev.next = next;
            prev = null;
            next = null;
        }
    }
}