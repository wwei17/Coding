package LeetCode;

public class PowerofFour {

	public boolean isPowerOfFour(int num) {
        return num != 0 && ((~num+1)& num) == num && ((num&0x55555555) == num);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
