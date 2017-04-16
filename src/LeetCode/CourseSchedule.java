package LeetCode;

import java.util.*;

public class CourseSchedule {
    
    public HashMap<Integer, Node> map;
    public ArrayList<Node> nodes;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(prerequisites);
        if(map.size() > numCourses) return false;
        Stack<Node> st = new Stack<Node>();
        HashMap<Node, Boolean> mp = new HashMap<Node, Boolean>();
        HashSet<Node> set = new HashSet<Node>();
        Node tempNode = null;
        ArrayList<Node> nodeSeq= new ArrayList<Node>();
        for(int i = 0; i < nodes.size(); i++){
            tempNode = nodes.get(i);
            st.push(tempNode);
            while(st.size() > 0){
                tempNode = st.peek();
                if(!set.contains(tempNode)){
                	set.add(tempNode);
                }
                
                if(!mp.containsKey(tempNode)){
                    mp.put(tempNode, true);
                    nodeSeq.add(tempNode);
                    for(int j=0; j< tempNode.next.size(); j++){
                        st.push(tempNode.next.get(j));
                    }
                }else{
                    if(tempNode != nodeSeq.get(nodeSeq.size()-1)){
                        return false;
                    }else{
                        st.pop();
                        nodeSeq.remove(tempNode);
                        mp.remove(tempNode);
                    }
                }
            }
        }
        return (set.size() == map.size());

    }
    
    public void buildGraph(int[][] values){
        map = new HashMap<Integer, Node>();
        nodes = new ArrayList<Node>();
        Node n0 = null; Node n1 = null;
        for(int i = 0; i < values.length; i++){
            if(map.containsKey(values[i][0])){
                n0 = map.get(values[i][0]);
            }else{
                n0 = new Node(values[i][0]);
                map.put(values[i][0], n0);
            }
            if(map.containsKey(values[i][1])){
                n1 = map.get(values[i][1]);
            }else{
                n1 = new Node(values[i][1]);
                map.put(values[i][1], n1);
            }
            n0.root = false;
            if(nodes.contains(n0)){
                nodes.remove(n0);
            }
            if(!nodes.contains(n1) && n1.root){
                nodes.add(n1);
            }
            if(!n1.next.contains(n0)){
                n1.next.add(n0);
            }
        }
        return;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	CourseSchedule sln = new CourseSchedule();
    	int[][] a = {{0,1},{1,0}};
    	Boolean result = sln.canFinish(2, a);
    	System.out.println(result);
	}
}

class Node{
    int val;
    ArrayList<Node> next;
    boolean root;
    public Node(int value){
        val = value;
        root = true;
        next = new ArrayList<Node>();
    }
}