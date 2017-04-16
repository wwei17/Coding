package LeetCode;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        
        Arrays.sort(tickets, new Comparator<String[]>(){
            public int compare(String[] s1, String[] s2){
                return s1[0].equals(s2[0])? s1[1].compareTo(s2[1]) : s1[0].compareTo(s2[0]);
            }
        });
        
        HashSet<String[]> set = new HashSet<String[]>();
        List<String> list = findItinerary(tickets, "JFK", set);
        list.add(0, "JFK");
        return list;
    }
    
    public List<String> findItinerary(String[][] tickets, String to, HashSet<String[]> set){
        List<String> list = null;
        if(set.size() == tickets.length) return new LinkedList<String>();
        for(int i = 0; i < tickets.length; i++){
            if(!set.contains(tickets[i]) && tickets[i][0].equals(to)){
                set.add(tickets[i]);
                list = findItinerary(tickets, tickets[i][1], set);
                set.remove(tickets[i]);
                if(list != null){
                    list.add(0,tickets[i][1]);
                    return list;
                }
            }
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
