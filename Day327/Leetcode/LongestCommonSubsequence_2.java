//Leetcode
//1143. Longest Common Subsequence - Tabulation/Bottom Up
//Time complexity: O(N*M) - There are two nested loops
//Space complexity: O(N*M) - We are using an external array of size 'N*M'. Stack Space is eliminated.

package Leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence_2 {

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    // Function to find the length of the Longest Common Subsequence (LCS)
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];
        // Initialize the dp array with -1 to indicate that subproblems are not solved
        // yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        // Initialize the first row and first column with zeros since LCS with an empty
        // string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS
                // length
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                // If the characters are different, choose the maximum LCS length by either
                // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
    }
}
