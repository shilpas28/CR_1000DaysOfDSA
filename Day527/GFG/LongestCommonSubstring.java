//GFG
//Longest Common Substring
//Time complexity: O(n*m)
//Space complexity: O(n*m)

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String str1 = "ABCDGH", str2 = "ACDGHR";
        System.out.println(longestCommonSubstr(str1, str2));
    }

    public static int longestCommonSubstr(String str1, String str2) {
        // code here
        int n = str1.length(), m = str2.length(), ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
