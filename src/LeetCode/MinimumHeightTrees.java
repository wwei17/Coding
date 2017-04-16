package LeetCode;

import java.util.*;

public class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        for(int i = 0; i < n ; i++){
            nodes.add(new TreeNode(i));
        }
        for(int i = 0; i < edges.length; i++){
            nodes.get(edges[i][0]).nexts.add(nodes.get(edges[i][1]));
            nodes.get(edges[i][1]).nexts.add(nodes.get(edges[i][0]));
        }
        HashSet<TreeNode> leaves = new HashSet<TreeNode>();
        for(int i = 0; i < n ; i++){
            if(nodes.get(i).nexts.size()<=1){
                leaves.add(nodes.get(i));
            }
        }
 
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        HashSet<TreeNode> visiting = new HashSet<TreeNode>();
        HashSet<TreeNode> temp = leaves;
        while(visited.size() < nodes.size()){
            visiting.clear();
            for(TreeNode temp1 : temp){
                if(temp1.nexts.size() <=1) visiting.add(temp1);
            }
            temp.clear();

            for(TreeNode temp1 : visiting){
                for(TreeNode temp2 : temp1.nexts){
                    temp1.nexts.remove(temp2);
                    temp2.nexts.remove(temp1);
                    if(!visited.contains(temp2)){
                        temp.add(temp2);
                    }
                }
            }
            for(TreeNode temp1: visiting){
                visited.add(temp1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(TreeNode temp1: visiting){
            list.add(temp1.val);
        }
        return list;
    }
    
    class TreeNode{
        int val;
        HashSet<TreeNode> nexts;
        TreeNode(int v){
            val = v;
            nexts = new HashSet<TreeNode>();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
