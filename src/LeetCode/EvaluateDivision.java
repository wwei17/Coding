package LeetCode;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Graph g = new Graph(equations, values);
        double[] distances = new double[queries.length];
        for(int i= 0 ; i < queries.length; i++){
            distances[i] = g.getDistance(queries[i][0], queries[i][1]);
        }
        return distances;
    }
    
    class Graph{
        HashMap<String, Node> nodes;
        HashMap<Node, HashMap<Node, Double>> d_map ;
        Graph(String[][] equations, double[] values){
            nodes = new HashMap<String, Node>();
            d_map = new HashMap<Node, HashMap<Node, Double>>();
            Node n1 = null, n2 = null;
            for(int i = 0 ; i < equations.length; i++){
                if(!nodes.containsKey(equations[i][0])) {
                    n1 = new Node(equations[i][0]);
                    nodes.put(equations[i][0], n1);
                }else{
                    n1 = nodes.get(equations[i][0]);
                }
                if(!nodes.containsKey(equations[i][1])) {
                    n2 = new Node(equations[i][1]);
                    nodes.put(equations[i][1], n2);
                }else{
                    n2 = nodes.get(equations[i][1]);
                }
                n1.neighbors.put(n2, values[i]);
                n1.neighbors.put(n1, 1.0);
                n2.neighbors.put(n1, 1/values[i]);
                n2.neighbors.put(n2, 1.0);
            }
        }
        
        double getDistance(String a, String b){
            
            if(!nodes.containsKey(a) || !nodes.containsKey(b)){
                return -1.0;
            }
            Node n1 = nodes.get(a);
            Node n2 = nodes.get(b);
            double d = getDistance(n1, n2);
            if(Math.abs(d+3.14159) > 0.001){
                return d;
            }
            Stack<Node> st = new Stack<Node>();
            st.push(n1);
            HashMap<Node, Double> map = new HashMap<Node, Double>();
            map.put(n1, 1.0);
            Node curr = null;
            while(st.size()>0){
                curr = st.pop();
                for (Node key : curr.neighbors.keySet()) {
                    if(key.equals(n2)){
                        d = map.get(curr)*curr.neighbors.get(key);
                        addToDMap(n1, n2, d);
                        return d;
                    }else if(map.containsKey(key)){
                        
                    }else{
                        d = map.get(curr)*curr.neighbors.get(key);
                        addToDMap(n1, key, d);
                        map.put(key, d);
                        st.push(key);
                    }
                }
            }
            addToDMap(n1, n2, -1);
            return -1;
        }
        
        double getDistance(Node n1, Node n2){
            if(d_map.containsKey(n1)){
                HashMap<Node, Double> temp = d_map.get(n1);
                if(temp.containsKey(n2)){
                    return temp.get(n2);
                }else{
                    return -3.14159;
                }
            }else{
                return -3.14159;
            }
        }
        
        void addToDMap(Node n1, Node n2, double d){
            HashMap<Node, Double> temp = null;
            if(d_map.containsKey(n1)){
                temp = d_map.get(n1);
            }else{
                temp = new HashMap<Node, Double>();
                d_map.put(n1, temp);
            }
            temp.put(n2, d);
        }
    } 
    
    class Node{
        HashMap<Node, Double> neighbors;
        String label;
        Node(String a){
            neighbors = new HashMap<Node, Double>();
            label = a;
        }
        
        public void addNeighbor(Node a, double distance){
            neighbors.put(a, distance);
        }
        
        @Override
        public boolean equals(Object obj){
            Node b = (Node)obj;
            return b.label.equals(this.label);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
