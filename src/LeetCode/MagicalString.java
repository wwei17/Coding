package LeetCode;

public class MagicalString {

    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int[] a = new int[n];
        int p1 = 3; int p2 = 2;
        a[0] = 1;a[1]=2; a[2] = 2;
        while(p1 < n){
            for(int j = 0; j < a[p2] && p1+j < n; j++){
                a[0]+=(a[p1-1]+1)%2;
                a[p1+j] = a[p1-1]%2+1;
            }
            p1+=a[p2];
            p2++;
        }
        return a[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicalString sln = new MagicalString();
		int a = sln.magicalString(20);
		//for(int i = 0 ; i<a.length; i++){
			System.out.print(a);
		//}
	}

}
