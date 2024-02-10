//Leetcode
//647. Palindromic Substrings - DP
//Time complexity: O(N^2)
//Space complexity: O(N^2)

package Leetcode;

public class PalindromicSubstrings_2 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
