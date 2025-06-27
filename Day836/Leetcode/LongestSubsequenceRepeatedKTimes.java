//Leetcode
//2014. Longest Subsequence Repeated k Times - DFS 
//Time complexity: O(26^L * N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.List;

public class LongestSubsequenceRepeatedKTimes {

    public static void main(String[] args) {
        String s = "letsleetcode";
        int k = 2;
        System.out.println(longestSubsequenceRepeatedK(s, k));
    }

    static String res = "";
    static List<Character> list = new ArrayList<>();

    public static String longestSubsequenceRepeatedK(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c = 'a'; c <= 'z'; c++)
            if (count[c - 'a'] >= k)
                list.add(c);
        dfs(s, "", k);
        return res;
    }

    // DFS 209ms
    static void dfs(String s, String sub, int k) {
        // terminating condition check
        if (sub.length() > 1 && !isSub(s, sub, k))
            return;
        if (sub.length() > res.length())
            res = sub;
        for (int i = list.size() - 1; i >= 0; i--) {
            String next = sub + list.get(i);
            dfs(s, next, k);
        }
    }

    static boolean isSub(String s, String sub, int k) {
        int j = 0;
        int repeat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < (k - repeat - 1) * sub.length())
                return false;
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
                j %= sub.length();
                if (j == 0) {
                    repeat++;
                    if (repeat == k)
                        return true;
                }
            }
        }
        return false;
    }
}
