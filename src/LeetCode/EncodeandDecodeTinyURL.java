package LeetCode;

import java.util.HashMap;

public class EncodeandDecodeTinyURL {

    private int count = 0;
    private HashMap<String, String> map1 = new HashMap<String, String>();
    private HashMap<String, String> map2 = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map1.putIfAbsent(longUrl, "http://tinyurl.com/"+count);
        map2.putIfAbsent("http://tinyurl.com/"+count, longUrl);
        count++;
        return map1.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map2.get(shortUrl);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
