//Leetcode
//3043. Find the Length of the Longest Common Prefix
//Time complexity: O(m x d + n x d) = O(m + n)
//Space complexity: O(n x d) = O(n)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTheLengthOfTheLongestCommonPrefix_2 {

    public static void main(String[] args) {
        int[] arr1 = { 1, 10, 100 };
        int[] arr2 = { 1000 };
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    static class Node {
        Map<Integer, Node> umc = new HashMap<>();
        boolean isEnd = false;
    }

    static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        // Inserting values into the trie
        public void insert(int a) {
            Node cur = root;
            String tmp = Integer.toString(a);
            for (int i = 0; i < tmp.length(); i++) {
                int num = tmp.charAt(i) - '0';
                if (!cur.umc.containsKey(num)) {
                    cur.umc.put(num, new Node());
                }
                cur = cur.umc.get(num);
            }
            cur.isEnd = true; // Denotes no node after this
        }

        // Matching the prefixes of a string/number
        public int prefixMatch(int b) {
            Node cur = root;
            String tmp = Integer.toString(b); // Converting to string for easy traversal
            int len = 0;
            for (int i = 0; i < tmp.length(); i++) {
                int num = tmp.charAt(i) - '0';
                // If no match is found, break
                if (!cur.umc.containsKey(num)) {
                    break;
                }
                cur = cur.umc.get(num);
                len++;
            }
            return len;
        }
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();
        for (int val : arr1) {
            t.insert(val);
        }
        int mx = Integer.MIN_VALUE;
        for (int val : arr2) {
            mx = Math.max(mx, t.prefixMatch(val));
        }
        return mx;
    }
}
