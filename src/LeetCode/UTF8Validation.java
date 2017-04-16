package LeetCode;

public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        return validUtf8Res(data, 0);
    }
    
    public boolean validUtf8Res(int[] data, int start){
        if(data == null || start == data.length) return true;
        int count = 0; int a = 128;
        while((data[start] & a) > 0){
            a >>= 1;
            count ++;
        }
        if(count == 0) return validUtf8Res(data, start+1);
        else if(count == 1) return false;
        else{
            if(start+count-1 >= data.length) return false;
            for(int i = 0 ; i < count-1; i++){
                if(data[start+i+1]>>>6 != 2) return false;
            }
            return validUtf8Res(data, start+count);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UTF8Validation sln = new UTF8Validation();
		System.out.println(sln.validUtf8(new int[]{235,140,4}));
	}

}
