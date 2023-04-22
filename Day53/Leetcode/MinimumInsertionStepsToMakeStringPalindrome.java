//Leetcode
//1312. Minimum Insertion Steps to Make a String Palindrome
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class MinimumInsertionStepsToMakeStringPalindrome {

    public static void main(String[] args) {
        String s = "zzazz";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];

        int[] dpPrev = new int[n];
        for (int start = n - 1; start >= 0; --start) {
            dp[start] = 1;
            for (int end = start + 1; end < n; ++end) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[end] = dpPrev[end - 1] + 2;
                } else {
                    dp[end] = Math.max(dpPrev[end], dp[end - 1]);
                }
            }
            dpPrev = dp.clone();
        }
        return dp[n - 1];
    }
}
