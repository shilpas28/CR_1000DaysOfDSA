//GFG
//Longest Common Subsequence
//Time complexity: O(N*M)
//Space complexity: O(N*M)

package GFG;

import java.util.Arrays;

public class LongestCommonSubsequence_2 {

    public static void main(String[] args) {
        int A = 6, B = 6;
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println(lcs(A, B, str1, str2));
    }

    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2) {
        // your code here
        int n = x;
        int m = y;
        int dp[][] = new int[n + 1][m + 1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        return dp[n][m];
    }
}
