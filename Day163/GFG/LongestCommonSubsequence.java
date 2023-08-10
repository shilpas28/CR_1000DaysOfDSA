//GFG
//Longest Common Subsequence
//Time complexity: O(N*M)
//Space complexity: O(N*M) + O(N+M)

package GFG;

import java.util.Arrays;

public class LongestCommonSubsequence {

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
        int dp[][] = new int[n][m];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        return lcsUtil(s1, s2, n - 1, m - 1, dp);
    }

    static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
        else
            return dp[ind1][ind2] = 0 + Math.max(lcsUtil(s1, s2, ind1, ind2 - 1, dp),
                    lcsUtil(s1, s2, ind1 - 1, ind2, dp));
    }
}
