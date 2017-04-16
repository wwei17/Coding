package LeetCode;

public class Base7 {

    public String convertToBase7(int num) {
        String sign = "";
        if(num == 0){
            return "0";
        }else if(num < 0){
            sign = "-";
            num = -num;
        }
        StringBuilder res = new StringBuilder();
        while(num > 0){
           res.append(num%7);
            num = num/7;
        }
        res.append(sign);
        return res.reverse().toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
