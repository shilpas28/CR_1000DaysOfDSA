//Leetcode
//208. Implement Trie (Prefix Tree)
//Time complexity: O(length of word) for all the operations
//Sapce complexity: O(1)

package Leetcode;

public class Trie {

    static TrieNode root; 

    static class TrieNode {
        TrieNode links[] = new TrieNode[26];
        boolean flag = false;
    
        public TrieNode() {
    
        }
    
        boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }
    
        TrieNode get(char ch) {
            return links[ch - 'a'];
        }
    
        void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    
        void setEnd() {
            flag = true;
        }
    
        boolean isEnd() {
            return flag;
        }
    };

    public Trie() {
        root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int type[] = { 1, 1, 2, 3, 2 };
        String value[] = { "hello", "help", "help", "hel", "hel" };
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            } else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }

}
