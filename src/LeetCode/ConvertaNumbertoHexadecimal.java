package LeetCode;

public class ConvertaNumbertoHexadecimal {

    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder("");
        String[] map = new String[]{  "0","1","2","3",
                                    "4","5","6","7",
                                    "8","9","a","b",
                                    "c","d","e","f" };
        int m = 0; 
        int i = -4;
        while(m == 0){
            i+=4;
            m = (num >>(28 - i)) & 15 ;
        }
        for(; i < 32; i+=4){
            m = (num >>(28 - i)) & 15 ;
            sb.append(map[m]);
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
