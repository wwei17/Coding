package LeetCode;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        char c = ' ';
        char cp = ' ';
        int max_l = 0;
        for(int i = 0 ; i < s.length(); i++){
            c = s.charAt(i);
            if(c == 'L'){ 
                if(cp == 'L') l++;
                else l = 1;
            }else if(c == 'A') a++;
            cp = c;
            max_l = Math.max(max_l, l);
        }
        return max_l <= 2 && a <= 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
