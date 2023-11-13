//GFG
//Shortest Common Supersequence
//Time complexity: O(Length(X) * Length(Y))
//Space complexity: O(Length(X) * Length(Y))

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String X = "abcd";
        String Y = "xycd";
        int m = X.length();
        int n = Y.length();
        System.out.println(shortestCommonSupersequence(X, Y, m, n));
    }

    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        // Your code here
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            dp[i][0] = 0;
        for (int i = 0; i < n; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (m + n) - dp[m][n];
    }
}
