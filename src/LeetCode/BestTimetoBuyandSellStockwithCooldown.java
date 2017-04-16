package LeetCode;

public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int b0 = 0, b1=-prices[0];
        int s0=0, s1=0, s2=0;
        for(int i = 0 ; i <prices.length; i++){
            b0 = Math.max(b1, s2-prices[i]);
            s0 = Math.max(s1, b1+prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
