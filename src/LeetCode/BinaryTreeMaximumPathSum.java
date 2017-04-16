package LeetCode;

import java.util.*;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        LinkedList<TreeNode> ll= new LinkedList<TreeNode>();
        TreeNode temp = root;
        ll.offer(temp);
        while(ll.size() > 0){
            temp = ll.poll();
            if(temp != null){
                st.push(temp);
                if(temp.left != null){
                    ll.offer(temp.left);
                }
                if(temp.right != null){
                    ll.offer(temp.right);
                }
            }
        }
        int leftValue= 0;
        int rightValue = 0;
        while(st.size()>0){
            temp = st.pop();
            if(temp.left != null){
                leftValue = map.get(temp.left);
            }else{
                leftValue = 0;
            }
            leftValue= leftValue>0?leftValue:0;
            if(temp.right != null){
                rightValue = map.get(temp.right);
            }else{
                rightValue = 0;
            }
            rightValue = rightValue>0? rightValue:0;
            if(leftValue > rightValue){
                map.put(temp, leftValue+temp.val);
            }else{
                map.put(temp, rightValue+temp.val);
            }
        }
        int max = Integer.MIN_VALUE;
        st.push(root);
        int tempMax = 0;
        while(st.size()>0){
            temp = st.pop();
            if(temp.left != null){
                st.push(temp.left);
                leftValue = map.get(temp.left);
            }else{
                leftValue = 0;
            }
            leftValue = leftValue > 0? leftValue:0;
            if(temp.right != null){
                st.push(temp.right);
                rightValue = map.get(temp.right);
            }else{
                rightValue = 0;
            }
            rightValue = rightValue>0? rightValue:0;
            tempMax = (leftValue < rightValue? leftValue: rightValue) + map.get(temp);
            if(tempMax > max){
                max = tempMax;
            }
        }
        return max;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(-1);
		TreeNode right = new TreeNode(-2);
		root.left = left;
		root.right = right;
		
		BinaryTreeMaximumPathSum sln = new BinaryTreeMaximumPathSum();
		System.out.println(sln.maxPathSum(root));
		
		
	}
}
class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
