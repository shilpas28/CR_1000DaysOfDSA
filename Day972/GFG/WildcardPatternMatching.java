//GFG
//Wildcard Pattern Matching
//Time complexity: O(n * m)
//Space complexity: O(n * m)

public class WildcardPatternMatching {

    public static void main(String[] args) {
        String txt = "abcde", pat = "a?c*";
        System.out.println(wildCard(txt, pat));
    }

    public static boolean wildCard(String txt, String pat) {
        // code here
        int n = txt.length();
        int m = pat.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // Base case: if pattern contains only '*'
        for (int i = 1; i <= m; i++) {
            if (pat.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pat.charAt(i - 1) == txt.charAt(j - 1)
                        || pat.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pat.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}
