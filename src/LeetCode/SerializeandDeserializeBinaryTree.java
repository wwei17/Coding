package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class SerializeandDeserializeBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Codec {

    // Encodes a tree to a single string.
	public String serialize(TreeNode root) {
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        StringBuilder temp = new StringBuilder("");
        TreeNode tempN = root;
        ll.offer(tempN);
        while(ll.size() > 0){
            tempN = ll.poll();
            if(tempN == null){
                temp.append("null ");
            }else{
                temp.append(tempN.val+" ");
                ll.offer(tempN.left);
                ll.offer(tempN.right);
            }
        }
        return temp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dd = data.trim().split(" ");
        int count = 1; int index = 0;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        LinkedList<TreeNode> listT = new LinkedList<TreeNode>();
        for(int i = 0; i < dd.length; i++){
            if(dd[i].equals("null")){
                list.add(null);
            }else{
                list.add(new TreeNode(Integer.parseInt(dd[i])));
            }
        }
        listT.offer(list.get(index));
        while(listT.size()>0){
            int n = 0;
            for(int i = 0 ; i < count; i++){
                TreeNode t = listT.poll();
                if(t != null){
                    n +=2;
                    index++;
                    listT.offer(list.get(index));
                    t.left = list.get(index);
                    index++;
                    listT.offer(list.get(index));
                    t.right = list.get(index);
                }
            }
            count = n;
        }
        return list.get(0);
        
    }
    
    class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}


