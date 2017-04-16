package LeetCode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        
        for(int i =digits.length - 1; i>=0; i--){
            if(i == digits.length - 1){
                digits[i] += 1;
            }else{
                digits[i] += carry;
            }
            
            if(digits[i] >= 10){
                digits[i] -= 10;
                carry = 1;
            }else{
                carry = 0;
                break;
            }
        }
        
        if(carry == 1){
            int[] newDigits = new int[digits.length +1];
            newDigits[0] = 1;
            for(int i = 1; i < digits.length; i++){
                newDigits[i] = digits[i];
            }
            return newDigits;
        }else{
            return digits;
        }
            
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
