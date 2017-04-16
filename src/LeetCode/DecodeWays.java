package LeetCode;

public class DecodeWays {
	
	
	public int numDecodings(String s) {
        if(s == null || s.length()==0){ 
            return 0;
        }else{
            return numDecodings(s.toCharArray(), 0, s.length()-1);
        } 
    }
    
    public int numDecodings(char[] cs, int start, int end){
        if(cs[start] == '0'){
            if(start != 0){
                if(cs[start-1] == '1' || cs[start] == '2'){
                    if(start < end){
                        return numDecodings(cs, start+1, end);
                    }else{
                        return 1;
                    }
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }else if(cs[start] == '2'){
            if(start < end){
                if(cs[start+1] <= '6'){
                    if(end - start > 1){
                        return numDecodings(cs, start+1, end) + numDecodings(cs, start+2, end);
                    }else{
                        return numDecodings(cs, start+1, end) + 1 ;
                    }
                }else{
                    return numDecodings(cs, start+1, end);
                }
            }else{
                return 1;
            }
        }else if(cs[start] == '1'){
            if(end - start > 1){
                return numDecodings(cs, start+1, end) + numDecodings(cs, start+2, end);
            }else if(end - start ==1){
                return numDecodings(cs, start+1, end) + 1 ;
            }else{
                return 1;
            }
        }else{
            if(start < end){
                return numDecodings(cs, start+1, end);
            }else{
                return 1 ;
            }
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays ds = new DecodeWays();
		System.out.println(ds.numDecodings("0"));
	}

}
