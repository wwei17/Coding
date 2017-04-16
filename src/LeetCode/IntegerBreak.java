package LeetCode;

public class IntegerBreak {

    public int integerBreak(int n) {
        return integerBreak(n, new int[n+1]);
    }
    
    public int integerBreak(int n, int[] mem){
        if(mem[n] != 0){
            return mem[n];
        }else if(n <= 2){
            return 1;
        }else{
            int max = 1;
            int curr = 0;
            for(int i = 1; i < n; i++){
                curr = i*integerBreak(n-i, mem);
                max = Math.max(max, i*(n-i));
                max = Math.max(max, curr);
            }
            mem[n] = max;
            return max;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
