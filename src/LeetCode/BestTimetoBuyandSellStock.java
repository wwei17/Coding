package LeetCode;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(prices.length == 0 ){
            return 0;
        }
        
        for(int i = 0 ; i < prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
            }
            
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
