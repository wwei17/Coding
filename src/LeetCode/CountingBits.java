package LeetCode;

public class CountingBits {

    public int[] countBits(int num) {
        int[] counts = new int[num+1];
        counts[0] = 0;
        if(num >= 1){
            counts[1] = 1;
        }
        int e = 1; int curr = 2; int l = (int)Math.pow(2, e);
        while(num >= l){
            for(int i = 0 ; i < l && curr <= num; i++){
                counts[curr] = 1+counts[i];
                curr++;
            }
            e++;
            l = (int)Math.pow(2, e);
        }
        return counts;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
