package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UniqueBinarySearchTreesII {

    HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> l = new ArrayList<TreeNode>();
        if(n == 0){
            l.add(null);
            return l;
        }else if(n == 1){
            TreeNode m = new TreeNode(1);
            l.add(m);
            if(!map.containsKey(1)) map.put(1,l);
            return l;
        }else if(n == 2){
            TreeNode n1 = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            n1.right = n2;
            l.add(n1);
            n1 = new TreeNode(1);
            n2 = new TreeNode(2);
            n2.left = n1;
            l.add(n2);
            if(!map.containsKey(2)) map.put(2,l);
            return l;
        }else{
            for(int i = 1; i <= n; i++){
                List<TreeNode> lleft = null;
                List<TreeNode> lright = null;
                if(map.containsKey(i-1)){
                    lleft = map.get(i-1);
                }else{
                    lleft = generateTrees(i-1);
                }
                lleft = copyList(lleft,0);
                if(map.containsKey(n-i)){
                    lright = map.get(n-i);
                }else{
                    lright = generateTrees(n-i);
                }
                lright = copyList(lright, i);
                for(int j = 0; j < lleft.size(); j++){
                    for(int k = 0; k< lright.size(); k++){
                        TreeNode m = new TreeNode(i);
                        m.left = lleft.get(j);
                        m.right = lright.get(k);
                        l.add(m);
                    }
                }
            }
        }
        if(!map.containsKey(n)) map.put(n,l);
        return l;
    }
    
    public List<TreeNode> copyList(List<TreeNode> l0, int offset){
        List<TreeNode> l1 = new ArrayList<TreeNode>();
        for(int i = 0; i < l0.size(); i++){
            TreeNode temp = l0.get(i);
            Stack<TreeNode> st0 = new Stack<TreeNode>();
            Stack<TreeNode> st1 = new Stack<TreeNode>();
            if(temp != null) {
                st0.push(temp);
                TreeNode n = new TreeNode(temp.val + offset);
                st1.push(n);
                l1.add(n);
            }else{
                l1.add(null);
            }
            TreeNode temp0, temp1;
            while(st0.size()!= 0){
                temp0 = st0.pop();
                temp1 = st1.pop();
                if(temp0.left != null){
                    st0.push(temp0.left);
                    TreeNode n1 = new TreeNode(temp0.left.val + offset);
                    temp1.left = n1;
                    st1.push(n1);
                }
                if(temp0.right != null){
                    st0.push(temp0.right);
                    TreeNode n1 = new TreeNode(temp0.right.val + offset);
                    temp1.right = n1;
                    st1.push(n1);
                }
            }
        }
        return l1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
