//GFG
//Word Break - Not accepted as TLE
//Time complexity: O(len(s)^2)
//Space complexity: O(len(s))

public class WordBreak {

    public static void main(String[] args) {
        String s = "ilike";
        String dictionary[] = { "i", "like", "gfg" };
        System.out.println(wordBreak(s, dictionary));
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    static TrieNode root;

    public static int wordBreak(String s, String[] dictionary) {
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
