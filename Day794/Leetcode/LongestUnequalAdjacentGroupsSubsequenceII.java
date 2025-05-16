//Leetcode
//2901. Longest Unequal Adjacent Groups Subsequence II
//Time complexity: O((n^2)*L) where n is the length of the given array and L is the length of each string in the string array word.
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII {

    public static void main(String[] args) {
        String[] words = { "bab", "dab", "cab" };
        int[] groups = { 1, 2, 2 };
        System.out.println(getWordsInLongestSubsequence(words, groups));
    }

    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (check(words[i], words[j]) &&
                        dp[j] + 1 > dp[i] &&
                        groups[i] != groups[j]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            ans.add(words[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
