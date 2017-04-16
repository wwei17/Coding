package LeetCode;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int m = 0;
        
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 3){
            return 5;
        }else{
            for(int i = 1; i <= n; i ++){
                m += numTrees(i-1) * numTrees(n-i);
            }
            return m;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
