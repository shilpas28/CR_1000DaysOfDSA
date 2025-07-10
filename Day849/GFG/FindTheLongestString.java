//GFG
//Find the longest string
//Time complexity: O(n * max(arr[i].size()) )
//Space complexity: O(n * max(arr[i].size()) )

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheLongestString {

    public static void main(String[] args) {
        String arr[] = { "p", "pr", "pro", "probl", "problem", "pros", "process", "processor" };
        System.out.println(longestString(arr));
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    static TrieNode root = new TrieNode();

    static void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isWord = true;
    }

    static boolean allPrefixesExist(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            if (node == null || !node.isWord)
                return false;
        }
        return true;
    }

    public static String longestString(String[] arr) {
        // code here
        for (String word : arr) {
            insert(word);
        }

        Arrays.sort(arr); // lexicographical order

        String result = "";
        for (String word : arr) {
            if (allPrefixesExist(word)) {
                if (word.length() > result.length() ||
                        (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}
