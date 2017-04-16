package LeetCode;

public class NumberofDigitOne {

    public int countDigitOne(int n) {
        long count = 0; 
        long curr = 0;
        long last = 0;
        long lv = 1;
        while(n / lv > 0){
            curr = n%(lv*10);
            if(curr >= 2*lv){
                count += lv;
            }else if(curr >= lv){
                count += last+1;
            }
            lv *= 10;
            count += n/lv*lv/10;
            last = curr;
        }
        return (int)count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
