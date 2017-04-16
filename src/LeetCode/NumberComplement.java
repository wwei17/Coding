package LeetCode;

public class NumberComplement {

    public int findComplement(int num) {
        int res = 0 ;
        for(int i = 0; i< 32; i++){
            if((num>>>(31-i)&1) == 1)
                break;
            res = res | (1 << 31-i);
        }
        return ~res & ~num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
