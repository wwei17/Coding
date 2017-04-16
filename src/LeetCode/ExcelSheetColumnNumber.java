package LeetCode;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int index = 0; int c = 1;
        for(int i = s.length()-1; i >=0; i--){
            index += (int)(s.charAt(i)-'A'+1) * c;
            c *= 26;
        }
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
