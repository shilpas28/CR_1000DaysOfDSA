//GFG
//Interleaved Strings - Not accepted as TLE
//Time complexity: O(n*m)
//Space complexity: O(m)

public class InterleavedStrings {

    public static void main(String[] args) {
        String s1 = "AAB", s2 = "AAC", s3 = "AAAABC";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // code here
        int x = s1.length();
        int y = s2.length();
        if (x + y != s3.length()) {
            return false;
        }

        boolean dp[][] = new boolean[x + 1][y + 1];
        dp[0][0] = true;
        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[x][y];
    }
}
