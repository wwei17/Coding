package LeetCode;

public class UglyNumber {

    public boolean isUgly(int num) {
        if(num <= 0) return false;
        else if(num == 1) return true;
        int temp = num;
        int prev_temp = num;
        int mod = 0;
        while(mod == 0 && temp > 1){
            prev_temp = temp;
            mod = temp%2;
            temp = prev_temp/2;
        }
        temp = prev_temp;
        mod = 0;
        while(mod == 0 && temp > 1){
            prev_temp = temp;
            mod = temp%3;
            temp = prev_temp/3;
        }
        temp = prev_temp;
        mod = 0;
        while(mod == 0 && temp > 1){
            prev_temp = temp;
            mod = temp%5;
            temp = prev_temp/5;
        }
        if(prev_temp == 2 || prev_temp ==3 || prev_temp ==5){
            return true;
        }else{
            return false;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
