package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Stack<UndirectedGraphNode> st = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode newHead = null;
        if(node != null){ 
            st.push(node);
            newHead = new UndirectedGraphNode(node.label);
            map.put(node, newHead);
        };
        while(st.size() >0){
            UndirectedGraphNode temp = st.pop();
            UndirectedGraphNode newNode = null;
            if(!map.containsKey(temp)){
                newNode = new UndirectedGraphNode(temp.label);
                map.put(temp, newNode);
            }else{
                newNode = map.get(temp);
            }
            for(int i = 0 ; i < temp.neighbors.size(); i++){
                UndirectedGraphNode nei = temp.neighbors.get(i);
                if(map.containsKey(nei)){
                    newNode.neighbors.add(map.get(nei));
                }else{
                    UndirectedGraphNode n0 = new UndirectedGraphNode(nei.label);
                    newNode.neighbors.add(n0);
                    map.put(nei,n0);
                    st.push(nei);
                }

            }
        }
        return newHead;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
}
