package LeetCode;

public class ReconstructOriginalDigitsfromEnglish {

    public String originalDigits(String s) {
        int [] map = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            map[s.charAt(i)-'a']++;
        }
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        char[] seq1 = {'z','w','u','x','g','o','s','v','h','i'};
        int [] seq2 = {0,2,4,6,8,1,7,5,3,9};
        int[] num_counts = new int[10];
        int k = 0;
        for(int i = 0 ; i < seq1.length; i++){
            k = map[seq1[i]-'a'];
            for(int j = 0 ;j < k; j++){
                remove(map, nums[seq2[i]]);
                num_counts[seq2[i]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num_counts.length ;i++){
            for(int j = 0 ; j < num_counts[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    
    public void remove(int[] map, String s){
        for(int i = 0 ; i < s.length(); i++){
            map[s.charAt(i)-'a']--;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructOriginalDigitsfromEnglish sln = new ReconstructOriginalDigitsfromEnglish();
		System.out.println(sln.originalDigits("zerozero"));
	}

}
