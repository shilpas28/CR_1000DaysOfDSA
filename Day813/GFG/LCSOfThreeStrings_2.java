//GFG
//LCS of three strings
//Time complexity: O (n1*n2*n3)
//Space complexity: O (n1*n2*n3)

public class LCSOfThreeStrings_2 {

    public static void main(String[] args) {
        String s1 = "geeks", s2 = "geeksfor", s3 = "geeksforgeeks";
        System.out.println(lcsOf3(s1, s2, s3));
    }

    static int lcsOf3(String s1, String s2, String s3) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    } else if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}
