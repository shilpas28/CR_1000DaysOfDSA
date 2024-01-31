//GFG
//Insert and Search in a Trie
//Time complexity: O(M+|key|)
//Space complexity: O(M) - Here M = sum of the length of all strings which are present in the list[]  

package GFG;

public class InsertAndSearchInATrie {

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    public static void main(String[] args) {
        // int n = 8;
        // TrieNode list[] = {"the", "a", "there", "answer", "any", "by", "bye",
        // "their"};
        // String key = "the";
        TrieNode root = new TrieNode();
        insert(root, "the");
        insert(root, "a");
        insert(root, "there");
        insert(root, "answer");
        insert(root, "any");
        insert(root, "by");
        insert(root, "bye");
        insert(root, "their");
        System.out.println(search(root, "the"));
    }

    // Function to insert string into TRIE.
    static void insert(TrieNode root, String key) {
        // Your code here
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            if (temp.children[key.charAt(i) - 'a'] == null) {
                temp.children[key.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[key.charAt(i) - 'a'];
            if (i == key.length() - 1)
                temp.isEndOfWord = true;
        }
    }

    // Function to use TRIE data structure and search the given string.
    static boolean search(TrieNode root, String key) {
        // Your code here
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            if (temp.children[key.charAt(i) - 'a'] == null)
                return false;
            temp = temp.children[key.charAt(i) - 'a'];
            if (i == key.length() - 1 && temp.isEndOfWord)
                return true;
        }
        return false;
    }
}
