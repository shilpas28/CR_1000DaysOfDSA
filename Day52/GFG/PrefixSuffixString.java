//GFG
//Prefix Suffix String - using Trie
//Time complexity: O(max(len(s1) , len(s2) ))
//Space complexity: O(1)

public class PrefixSuffixString {

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        TrieNode() {
            this.isEndOfWord = true;
            this.children = new TrieNode[26];
        }
    }

    public static void insert(String s, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();

            cur = cur.children[index];
        }
        cur.isEndOfWord = true;
    }

    public static boolean search(String s, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (cur.children[index] == null)
                return false;

            cur = cur.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s1 = { "cat", "catanddog", "lion" };
        String[] s2 = { "cat", "dog", "rat" };
        System.out.println(prefixSuffixString(s1, s2));
    }

    public static int prefixSuffixString(String s1[], String s2[]) {
        TrieNode root = new TrieNode();

        for (String val : s1) {
            StringBuffer rev = new StringBuffer(val);
            rev.reverse();

            insert(val, root);
            insert(rev.toString(), root);
        }

        int ans = 0;
        for (String val : s2) {
            StringBuffer rev = new StringBuffer(val);
            rev.reverse();
            if (search(val, root) || search(rev.toString(), root))
                ans++;
        }
        return ans;
    }
}
