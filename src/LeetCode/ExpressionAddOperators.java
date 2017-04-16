package LeetCode;

import java.util.*;

public class ExpressionAddOperators {

	 	int target = 0;
	    String num = "";
	    public List<String> addOperators(String num, int target) {
	        this.target = target;
	        this.num = num;
	        List<String> list = new ArrayList<String>();
	        getResult(list, 0,  "", (long)0, (long)0);
	        return list;
	    }
	    
	    private void getResult(List<String> list, int index, String str, long currResult, long prevResult){
	        if(index == num.length() && currResult == this.target){
	            list.add(str);
	        }else{
	            for(int i = index; i < num.length(); i++){
	                if(i != index && num.charAt(index) == '0'){
	                    break;
	                }else{
	                    long r = Long.parseLong(num.substring(index, i+1));
	                    if(index == 0){
	                        getResult(list, i+1, r+"", r , r);
	                    }else{
	                        getResult(list, i+1, str+"+"+r, currResult+r , r);
	                        getResult(list, i+1, str+"-"+r, currResult-r , -r);
	                        getResult(list, i+1, str+"*"+r, currResult - prevResult + prevResult*r , prevResult*r);
	                    }
	                    
	                }
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
