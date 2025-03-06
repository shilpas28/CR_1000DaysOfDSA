//GFG
//Longest Common Subsequence
//Time complexity: O(N*M)
//Space complexity: O(N*M) + O(N+M)

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "ABCDGH", s2 = "AEDFHR";
        System.out.println(lcs(s1, s2));
    }

    static int lcs(String s1, String s2) {
        // code here
        int x = s1.length();
        int y = s2.length();
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
