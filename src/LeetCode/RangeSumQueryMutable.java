package LeetCode;

public class RangeSumQueryMutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArray numArray = new NumArray(new int[]{0,9,5,7,3});
		numArray.sumRange(4,4);
		numArray.sumRange(2,4);
		numArray.sumRange(3,3);
		numArray.update(4,5);
		numArray.update(1,7);
		numArray.update(0,8);
		numArray.sumRange(1,2);
		numArray.update(1,9);
		numArray.sumRange(4,4);
		numArray.update(3,4);
	}

}

class NumArray {
    private TreeNode root;
    
    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length -1);
    }
    
    private TreeNode build(int[] nums, int start, int end){
        TreeNode n = null;
        if(start > end){
            
        }else if(start == end){
            n = new TreeNode();
            n.left_i = start;
            n.right_i = end;
            n.sum = nums[start];
        }else{
            n = new TreeNode();
            int mid = (start+end)/2;
            TreeNode left = build(nums, start, mid);
            TreeNode right = build(nums, mid+1, end);
            n.sum = left.sum+right.sum;
            n.left_i = start;
            n.right_i = end;
            n.left = left;
            n.right = right;
        }
        return n;
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(TreeNode root, int i, int val){
        if(root.left_i == i && root.right_i == i){
            root.sum = val;
        }else{
            int mid = (root.left_i+root.right_i)/2;
            if(mid < i){
                update(root.right, i, val);
            }else{
                update(root.left, i, val);
            }
            root.sum = root.left.sum+root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(TreeNode root, int i, int j){
        if(root.left_i == i && root.right_i == j){
            return root.sum;
        }else{
            int mid = (root.left_i+root.right_i)/2;
            if(mid >= j){
                return sumRange(root.left, i, j);
            }else if(mid < i){
                return sumRange(root.right, i, j);
            }else{
                return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
            }
        }
    }
    
    class TreeNode{
        int sum;
        int left_i;
        int right_i;
        TreeNode left;
        TreeNode right;
        TreeNode(){
            left = null;
            right = null;
        }
    }
}
