//Leetcode
//2014. Longest Subsequence Repeated k Times - BFS
//Time complexity: O(26^L * N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestSubsequenceRepeatedKTimes_2 {

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
        bfs(s, k);
        return res;
    }

    public static String bfs(String s, int k) {
        Queue<String> q = new LinkedList<>();
        q.offer("");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                for (char c : list) {
                    String next = cur + c;
                    if (isSub(s, next, k)) {
                        res = next;
                        q.offer(next);
                    }
                }
            }
        }
        return res;
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
