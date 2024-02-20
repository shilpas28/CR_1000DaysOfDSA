//GFG
//Word Break
//Time complexity: O(len(s)^2)
//Space complexity: O(len(s))

package GFG;

import java.util.ArrayList;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class WordBreak {

    public static void main(String[] args) {

        // B = { "i", "like", "sam", "sung", "samsung", "mobile"}
        ArrayList<String> B = new ArrayList<>();
        B.add("i");
        B.add("like");
        B.add("sam");
        B.add("sung");
        B.add("Samsung");
        B.add("mobile");
        String A = "ilike";
        int n = B.size();
        System.out.println(wordBreak(n, A, B));
    }

    static TrieNode root;

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        // code here
        // Initialize the root of the trie
        root = new TrieNode();
        // Build the trie
        for (String word : dictionary) {
            insert(word);
        }
        // Check if the string can be segmented using the trie
        return canSegmentString(s, root) ? 1 : 0;
    }

    static void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    static boolean canSegmentString(String s, TrieNode root) {
        int n = s.length();
        if (n == 0)
            return true;
        TrieNode current = root;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (current.children[ch - 'a'] == null)
                return false;
            current = current.children[ch - 'a'];
            if (current.isEndOfWord && canSegmentString(s.substring(i + 1), root))
                return true;
        }
        return false;
    }

}
