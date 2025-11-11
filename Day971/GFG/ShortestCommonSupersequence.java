//GFG
//Shortest Common Supersequence
//Time complexity: O(n*m)
//Space complexity: O(m)

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s1 = "geek", s2 = "eke";
        System.out.println(minSuperSeq(s1, s2));
    }

    public static int minSuperSeq(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            dp[i][0] = 0;
        for (int i = 0; i < n; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (m + n) - dp[m][n];
    }
}
