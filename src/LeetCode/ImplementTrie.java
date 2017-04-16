package LeetCode;

import java.util.HashMap;

public class ImplementTrie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TrieNode {
    HashMap<Character,TrieNode> map;
    char val;
    boolean end;
    // Initialize your data structure here.
    public TrieNode() {
        val = ' ';
        end = false;
        map = new HashMap<Character,TrieNode>();
    }
    
    public TrieNode(char c) {
        val = c;
        end = false;
        map = new HashMap<Character,TrieNode>();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tempNode = root;
        char tempChar = ' ';
        for(int i = 0; i < word.length(); i++){
            tempChar = word.charAt(i);
            if(!tempNode.map.containsKey(tempChar)){
                tempNode.map.put(tempChar, new TrieNode(tempChar));
            }
            tempNode = tempNode.map.get(tempChar);
        }
        tempNode.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode tempNode = root;
        char tempChar = ' ';
        for(int i = 0; i < word.length(); i++){
            tempChar = word.charAt(i);
            if(!tempNode.map.containsKey(tempChar)){
                return false;
            }
            tempNode = tempNode.map.get(tempChar);
        }
        return tempNode.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode tempNode = root;
        char tempChar = ' ';
        for(int i = 0; i < prefix.length(); i++){
            tempChar = prefix.charAt(i);
            if(!tempNode.map.containsKey(tempChar)){
                return false;
            }
            tempNode = tempNode.map.get(tempChar);
        }
        return true;
    }
}