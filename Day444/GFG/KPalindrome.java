//GFG
//K-Palindrome
//Time complexity: O(n*n)
//Space complexity: O(n*n)

package GFG;

public class KPalindrome {

    public static void main(String[] args) {
        String str = "abcdecba";
        int n = 8, k = 1;
        System.out.println(kPalindrome(str, n, k));
    }

    public static int kPalindrome(String str, int n, int k) {
        // code here
        int dp[][] = new int[n][n];
        for (int i = 2; i <= n; i++) {
            for (int row = 0; row <= n - i; row++) {
                int col = row + i - 1;
                if (str.charAt(row) == str.charAt(col))
                    dp[row][col] = dp[row + 1][col - 1];
                else
                    dp[row][col] = Math.min(dp[row][col - 1], dp[row + 1][col]) + 1;
            }
        }
        return dp[0][n - 1] <= k ? 1 : 0;
    }
}
