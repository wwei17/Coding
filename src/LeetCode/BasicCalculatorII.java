package LeetCode;

public class BasicCalculatorII {

    public int calculate(String s) {
        int n1 = 0 , n2 = 1, last = 0;
        char op1 = '+', op2 = '*';
        char c = ' ';
        int i = 0 ;
        while(i < s.length()){
            c = s.charAt(i);
            if(c >= '0' && c <='9'){
                last = last*10+ c - '0';
            }else{
                if(c == ' '){
                    
                }else{
                    if(c == '*' || c == '/'){
                        n2 = calculate(n2, op2, last);
                        op2 = c;
                    }else{
                        n1 = calculate(n1, op1, calculate(n2, op2, last));
                        op1 = c;
                        op2='*';
                        n2=1;
                    }
                    last = 0;
                }
            }
            i++;
        }
        return calculate(n1, op1, calculate(n2, op2, last));
    }
    
    public int calculate(int n1, char op, int n2){
        if(op == '+'){
            return n1+n2;
        }else if(op == '-'){
            return n1-n2;
        }else if(op == '*'){
            return n1*n2;
        }else{
            return n1/n2;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
