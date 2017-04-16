package LeetCode;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] map = new String[26];

        String [] tokens = str.split(" ", -1);
        if(tokens.length != pattern.length()) return false;
        for(int i = 0 ; i < map.length; i++){
            map[i] = null;
        }
        int index=0;
        for(int i = 0 ; i < tokens.length; i++){
            index = pattern.charAt(i)-'a';
            if(map[index] == null){
                map[index] = tokens[i];
            }else if(!map[index].equals(tokens[i])){
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPattern sln = new WordPattern();
		System.out.println(sln.wordPattern("abba",
				"dog dog dog dog"));
	}

}
