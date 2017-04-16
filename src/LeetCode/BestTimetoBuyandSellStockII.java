package LeetCode;

public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        
        int low = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >  low){
                profit += prices[i] - low;
            }
            low = prices[i];
        }        
        return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
