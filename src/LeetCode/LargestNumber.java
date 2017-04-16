package LeetCode;


public class LargestNumber {

    public String largestNumber(int[] num) {
        String temp1=""; String temp2="";
        int result;
        for(int i = 0; i < num.length; i++){
            
            for(int j = i+1; j< num.length; j++){
                temp1 = num[i]+""+num[j];
                temp2 = num[j]+""+num[i];
                result = temp1.compareTo(temp2);
                if(result < 0){
                	int temp_s = num[i];
                	num[i] = num[j];
                	num[j] = temp_s;
                }
            }
            
        }
        StringBuffer sb = new StringBuffer();
        if(num[0] == 0){ 
        	return "0";
        }
        else{
	        for(int i = 0 ; i < num.length; i++){
	        	sb.append(num[i]);
	        }
	        
	        
	        return sb.toString();
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber s = new LargestNumber();
		int[] a = {121,12};
		System.out.println(s.largestNumber(a));
	}

}
