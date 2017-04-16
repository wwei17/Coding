package LeetCode;

public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int [] bitsArray = new int[words.length];
        for(int i = 0 ; i<bitsArray.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                bitsArray[i] |= 1 << (int)(words[i].charAt(j)-'a');
            }
        }
        int max = 0; int temp = 0;
        for(int i = 0 ; i < bitsArray.length-1; i++){
            for(int j = i+1; j < bitsArray.length; j++){
                if((bitsArray[i] | bitsArray[j]) == (bitsArray[i] ^ bitsArray[j])){
                    temp = words[i].length() * words[j].length();
                    if(temp > max){
                        max = temp;
                    }
                }
            }
        }
        
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
