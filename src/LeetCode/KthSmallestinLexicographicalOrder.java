package LeetCode;

public class KthSmallestinLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        long i = 1; int ten = 1;
        while(k > 1){
            if(i*10 <= n){
                i = i*10;
                ten = ten*10;
            }else if(i+1 < n && i%10 != 9){
                i++;
            }else{
                while(i%10 == 9 || i == n){
                    i /= 10;
                }
                i++;
            }
            k--;
        }
        return (int)i;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestinLexicographicalOrder sln = new KthSmallestinLexicographicalOrder();
		System.out.println(sln.findKthNumber(681692778, 351251360));
	}

}
