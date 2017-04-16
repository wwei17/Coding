package LeetCode;

public class StringtoInteger {

	public int atoi(String str) {
        long result = 0;
        int i = 0;
        int sign = 1;
        if(str.length() == 0) return 0;
        while(str.charAt(i) == ' '){
            i++;
        }
        

        if(str.charAt(i) == '-'){
            sign = -1*sign;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }
            
      
        
        int j = i;
        while(i < str.length()){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if(result == 214748364){
                    if(sign == 1){
                        if(str.charAt(i)-'0' >=7){
                            return 2147483647;
                        }
                    }else{
                        if(str.charAt(i)-'0' >=8){
                            return -2147483648;
                        } 
                    }
                }else if(result > 214748364){
                    if(sign == 1){
                    	return 2147483647;
                    }else{
                        return -2147483648;
                    }
                }
                
                result *= 10;
                result += str.charAt(i)-'0';
                i++;
            }else{
                break;
            }
        }

        return (int) (sign*result);
     
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
