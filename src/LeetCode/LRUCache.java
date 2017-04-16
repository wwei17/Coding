package LeetCode;
import java.util.HashMap;

public class LRUCache {
	
	
    int cap = 0;
    HashMap map;
    BiNode head = null, tail = null;
    
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, BiNode>();
    }
    
    public int get(int key){
         if(!map.containsKey(key)){
             return -1;
         }else{
             BiNode node = (BiNode)(map.get(key));

             if(node.prev != null){
                 if(node.next == null && node.prev != null){
                     tail = node.prev;
                     tail.next = null;
                 }
                 
                 if(node.next != null){
                     node.next.prev = node.prev;
                 } 
                 node.prev.next = node.next;
                 node.next = head;
                 node.prev = null;
                 head.prev = node;
             }
             
             
             head = node;
             return (int)(node.data);
         }
         
    }
    
    public void set(int key, int value) {
        if(cap == 0 || map.containsKey(key)) return;
        if(map.size() == cap && !map.containsKey(key)){
            
            int k = tail.key;
            map.remove(k);
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
            
            
        }
        BiNode node = new BiNode(key,value);
        map.put(key,node);
        node.next=head;
        if(head != null){
            head.prev = node;
        }

        head = node;
        if(map.size() == 1){
            tail = head;
            
        }
    }
    class BiNode{
        BiNode next;
        BiNode prev;
        int key;
        Object data;
        BiNode(int k, Object d){
            key = k;
            data = d;
            next = null;
            prev = null;
        }
    }
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(10);
    	cache.set(10,13);
    	cache.set(3,17);
    	cache.set(6,11);
    	cache.set(10,5);
    	cache.set(9,10);
    	cache.get(13);
    	cache.set(2,19);
    	cache.get(2);
    	cache.get(3);
    	cache.set(5,25);
    	cache.get(8);
    	cache.set(9,22);
    	cache.set(5,5);
    	cache.set(1,30);
    	cache.get(11);
    	cache.set(9,12);
    	cache.get(7);
    	cache.get(5);
    	cache.get(8);
    	cache.get(9);
    	cache.set(4,30);
    	cache.set(9,3);
    	cache.get(9);
    	cache.get(10);
    	cache.get(10);
    	cache.set(6,14);
    	cache.set(3,1);
    	cache.get(3);
    	cache.set(10,11);
    	cache.get(8);
    	cache.set(2,14);
    	cache.get(1);
    	cache.get(5);
    	cache.get(4);
    	cache.set(11,4);
    	cache.set(12,24);
    	cache.set(5,18);
    	cache.get(13);
    	cache.set(7,23);
    	cache.get(8);
    	cache.get(12);
    	cache.set(3,27);
    	cache.set(2,12);
    	cache.get(5);
    	cache.set(2,9);
    	cache.set(13,4);
    	cache.set(8,18);
    	cache.set(1,7);
    	cache.get(6);
    	cache.set(9,29);
    	cache.set(8,21);
    	cache.get(5);
    	cache.set(6,30);
    	cache.set(1,12);
    	cache.get(10);
    	cache.set(4,15);
    	cache.set(7,22);
    	cache.set(11,26);
    	cache.set(8,17);
    	cache.set(9,29);
    	cache.get(5);
    	cache.set(3,4);
    	cache.set(11,30);
    	cache.get(12);
    	cache.set(4,29);
    	cache.get(3);
    	cache.get(9);
    	cache.get(6);
    	cache.set(3,4);
    	cache.get(1);
    	cache.get(10);
    	cache.set(3,29);
    	cache.set(10,28);
    	cache.set(1,20);
    	cache.set(11,13);
    	cache.get(3);
    	cache.set(3,12);
    	cache.set(3,8);
    	cache.set(10,9);
    	cache.set(3,26);
    	cache.get(8);
    	cache.get(7);
    	cache.get(5);
    	cache.set(13,17);
    	cache.set(2,27);
    	cache.set(11,15);
    	cache.get(12);
    	cache.set(9,19);
    	cache.set(2,15);
    	cache.set(3,16);
    	cache.get(1);
    	cache.set(12,17);
    	cache.set(9,1);
    	cache.set(6,19);
    	cache.get(4);
    	cache.get(5);
    	cache.get(5);
    	cache.set(8,1);
    	cache.set(11,7);
    	cache.set(5,2);
    	cache.set(9,28);
    	cache.get(1);
    	cache.set(2,2);
    	cache.set(7,4);
    	cache.set(4,22);
    	cache.set(7,24);
    	cache.set(9,26);
    	cache.set(13,28);
    	cache.set(11,26);
    	
    	
    	
    }
}