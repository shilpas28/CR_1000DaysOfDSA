//Leetcode
//1143. Longest Common Subsequence - Memoization/Top Down
//Time complexity: O(N*M) - There are N*M states therefore at max 'N*M' new problems will be solved.
//Space complexity: O(N*M) + O(N+M) - We are using an auxiliary recursion stack space(O(N+M)) (see the recursive tree, in the worst 
//case, we will go till N+M calls at a time) and a 2D array ( O(N*M)).

package Leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

     // Function to find the length of the Longest Common Subsequence (LCS)
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][m];
        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        // Call the recursive function to find the LCS length
        return lcsUtil(text1, text2, n - 1, m - 1, dp);
    }

    // Recursive function to find the length of the Longest Common Subsequence (LCS)
    static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // Base case: If either of the strings reaches the end, return 0
        if (ind1 < 0 || ind2 < 0)
            return 0;
        // If the result for this subproblem has already been calculated, return it
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        // If the characters at the current indices are the same, increment the LCS length
        if (s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
        // If the characters are different, choose the maximum LCS length by either
        // skipping a character in s1 or skipping a character in s2
        else
            return dp[ind1][ind2] = Math.max(lcsUtil(s1, s2, ind1, ind2 - 1, dp),
                    lcsUtil(s1, s2, ind1 - 1, ind2, dp));
    }
}
