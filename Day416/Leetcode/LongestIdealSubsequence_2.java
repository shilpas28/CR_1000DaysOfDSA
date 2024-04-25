//Leetcode
//2370. Longest Ideal Subsequence
//Time complexity: O(N)
//Space complexity: O(26)

package Leetcode;

public class LongestIdealSubsequence_2 {

    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {
        int ans = 0, n = s.length();
        int dp[] = new int[26];
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            dp[ch] += 1;
            for (int j = Math.max(0, ch - k); j <= Math.min(25, ch + k); j++) {
                if (j != ch)
                    dp[ch] = Math.max(dp[j] + 1, dp[ch]);
            }
            ans = Math.max(ans, dp[ch]);
        }
        return ans;
    }
}
