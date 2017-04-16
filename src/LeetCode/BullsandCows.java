package LeetCode;

public class BullsandCows {

	  public String getHint(String secret, String guess) {
        int cows = 0;
        int [] a = new int[10];
        
        for(int i = 0; i < secret.length(); i++){
            a[secret.charAt(i)-'0']++;
            a[guess.charAt(i)-'0']--;
            if(secret.charAt(i) != guess.charAt(i)){
                cows++;
            }
            
        }
        int count = 0;
        for(int i = 0; i < 10; i++){
            count += a[i] > 0? a[i] : -a[i];
        }
        count = count/2;
        return (secret.length()-cows)+"A"+(cows-count)+"B";
    }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
