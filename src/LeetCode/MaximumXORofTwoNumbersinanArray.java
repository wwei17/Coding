package LeetCode;

public class MaximumXORofTwoNumbersinanArray {

    public int findMaximumXOR(int[] nums) {
        Cell root = new Cell();
        Cell curr = root;
        for(int i = 0 ; i< nums.length; i++){
            for(int j = 0 ; j < 32; j++){
                if(((nums[i] >> (31 - j) & 1) == 0)){
                    if(curr.c0 == null) curr.c0 = new Cell();
                    curr = curr.c0;
                }else{
                    if(curr.c1 == null) curr.c1 = new Cell();
                    curr = curr.c1;
                }
            }
            curr = root;
        }
        int res = 0;
        int next_bit = 0;
        int max = 0;
        for(int val : nums){
            res = 0;
            curr = root;
            for(int i = 0 ; i < 32; i++){
                if(((val >> (31-i)) & 1) == 0){
                    if(curr.c1 != null){
                        curr = curr.c1;
                        next_bit = 1;
                    }else{
                        curr = curr.c0;
                        next_bit = 0;
                    }
                }else{
                    if(curr.c0 != null){
                        curr = curr.c0;
                        next_bit = 1;
                    }else{
                        curr = curr.c1;
                        next_bit = 0;
                    }
                }
                res |= next_bit << (31-i);
            }
            max = Math.max(max, res);
        }
        return max;
    }
    
    class Cell{
        Cell c0, c1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumXORofTwoNumbersinanArray sln = new MaximumXORofTwoNumbersinanArray();
		System.out.println(sln.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
	}

}
