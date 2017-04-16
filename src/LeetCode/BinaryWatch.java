package LeetCode;

import java.util.*;

public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        if(num > 9) return list;
        List<Integer> num_list = getSeq(num, 10, new HashMap<Integer, ArrayList<Integer>>());
        for(int i = 0 ; i < num_list.size(); i++){
            int hours = (num_list.get(i)) >>> 6 & 15;
            int mins = (num_list.get(i)) & 63;
            if(hours < 12 && mins < 60){
                list.add(hours+":"+(mins >= 10? mins: "0"+mins));
            }
        }
        return list;
    }
    
    public List<Integer> getSeq(int n, int m, HashMap<Integer, ArrayList<Integer>> map){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int key = n << 4 | m;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(m == 1){
            if(n == 0){
                list.add(0);
            }if(n == 1){
                list.add(1);
            }
            map.put(key, list);
            return list;
        }
        List<Integer> list3 = getSeq(n, m-1, map);
        for(int i = 0 ; i <list3.size(); i++){
            list.add(list3.get(i) << 1 | 0);
        }
        if(n > 0){
            List<Integer> list2 = getSeq(n-1, m-1, map);
            for(int i = 0 ; i <list2.size(); i++){
                list.add(list2.get(i) << 1 | 1);
            }
        }
        map.put(key,list);
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
