//Leetcode
//2900. Longest Unequal Adjacent Groups Subsequence I - Dynamic Programming
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    public static void main(String[] args) {
        String[] words = { "e", "a", "b" };
        int[] groups = { 0, 0, 1 };
        System.out.println(getLongestSubsequence(words, groups));
    }

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxLen = 1, endIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            int bestLen = 1;
            int bestPrev = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (groups[i] != groups[j] && dp[j] + 1 > bestLen) {
                    bestLen = dp[j] + 1;
                    bestPrev = j;
                }
            }
            dp[i] = bestLen;
            prev[i] = bestPrev;
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = endIndex; i != -1; i = prev[i]) {
            res.add(words[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
