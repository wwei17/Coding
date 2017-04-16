package LeetCode;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int i = 0 ; i < ransomNote.length(); i++){
            map[ransomNote.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < magazine.length(); i++){
            map[magazine.charAt(i)-'a']--;
        }
        for(int i = 0 ; i < map.length; i++){
            if(map[i] > 0){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
