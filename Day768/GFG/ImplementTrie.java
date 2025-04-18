//GFG
//Implement Trie
//Time complexity:
//Space complexity:

public class ImplementTrie {

    // Trie class implementation
    static class Trie {
        // TrieNode class representing each node in the Trie
        class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                children = new TrieNode[26]; // For lowercase a-z
                isEndOfWord = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode(); // Initialize root
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        // Search for a word in the Trie
        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current.isEndOfWord;
        }

        // Check if a prefix exists in the Trie
        public boolean isPrefix(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
