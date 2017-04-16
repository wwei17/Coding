package LeetCode;

public class AddBinary {

	public String addBinary(String a, String b) {
        int ap = 0;
        int bp = 0;
        int cp = 0;
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < Math.min(a.length(), b.length()); i++){
            ap = (int)(a.charAt(a.length()-i-1) - 48);
            bp = (int)(b.charAt(b.length()-i-1) - 48);
            sum = ap + bp + cp;
            if(sum == 3){
                cp = 1;
                sum = 1;
            }else if(sum == 2){
                cp = 1;
                sum = 0;
            }else if(sum == 1){
                cp = 0;
                sum = 1;
            }else{      //sum == 0
                cp = 0;
                sum = 0;
            }
            sb.insert(0,sum+"");
        }
        
        String left = (a.length()>b.length())? a : b;
        int dif = Math.abs(a.length()-b.length());
        for(int i = 0; i < dif; i++){
            ap = (int)(left.charAt(dif-1-i) - 48);
            sum = ap + cp;
            if(sum == 2){
                cp = 1;
                sum = 0;
            }else if(sum == 1){
                cp = 0;
                sum = 1;
            }else{      //sum == 0
                cp = 0;
                sum = 0;
            }
            sb.insert(0,sum+"");
        }
        if(cp == 1){
            sb.insert(0,cp+"");
        }
        
        return sb.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
