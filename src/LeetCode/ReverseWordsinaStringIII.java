package LeetCode;

public class ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        int p1 = 0; int p2 = 0;
        char[] cs = s.toCharArray();
        char temp = ' ';
        while(p2 < cs.length){
            while(p1 < cs.length && cs[p1]==' '){
                p1++;
            }
            p2 = p1;
            while(p2 < cs.length && cs[p2] != ' '){
                p2++;
            }
            for(int i = p1, j = p2-1; i < j; i++, j--){
                temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
            }
            p1 = p2;
        }
        return new String(cs);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaStringIII sln = new ReverseWordsinaStringIII();
		System.out.println(sln.reverseWords("Let's take LeetCode contest"));
	}

}
