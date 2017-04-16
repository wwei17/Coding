package LeetCode;

public class GasStation {

	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int[] sum = new int[n];
        int max_i = 0;
        for(int i = 0 ; i < n; i++){
            sum[i] = gas[i] - cost[i];
        }
        int sum_0;
        int i = 0;
        while(i < n){
            if(sum[i] >= 0){
                sum_0 = 0;
                for(int j = 0 ; j< n; j++){
                    sum_0 += sum[(i+j)%n];
                    if(sum_0 < 0){
                        i += j;
                        break;    
                    } 
                    else if(j == n-1) return i;
                }
            }
            i++;
        }
        return -1;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
