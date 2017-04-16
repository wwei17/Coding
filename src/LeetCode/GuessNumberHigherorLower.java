package LeetCode;

public class GuessNumberHigherorLower {

    public int guessNumber(int n) {
        long start = 1;
        long end = n;
        long mid = 0;
        int guess = 1;
        while(guess != 0){
            mid = (start + end) / 2;
            guess = guess((int)mid);
            if(guess < 0){
                end = mid;
            }else if(guess > 0){
                start = mid + 1;
            }
        }
        return (int)mid;
    }
    
    //fake
    public int guess(int i){
    	return 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
