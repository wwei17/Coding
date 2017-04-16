package LeetCode;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int z = x^y; int count = 0;
        for(int i = 0 ; i< 32; i++){
            count += (z >> i)&1;
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
