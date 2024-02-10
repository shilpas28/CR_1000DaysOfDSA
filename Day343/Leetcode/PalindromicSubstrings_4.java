//Leetcode
//647. Palindromic Substrings - Manacher's algorithm
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class PalindromicSubstrings_4 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        StringBuilder t = new StringBuilder("#");

        for (char c : s.toCharArray()) {
            t.append(c).append("#");
        }
        n = t.length();
        int[] dp = new int[n];
        int center = 0, right = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                dp[i] = Math.min(right - i, dp[mirror]);
            }
            // Attempt to expand palindrome centered at i
            int a = i + (1 + dp[i]);
            int b = i - (1 + dp[i]);
            while (a < n && b >= 0 && t.charAt(a) == t.charAt(b)) {
                dp[i]++;
                a++;
                b--;
            }
            // If palindrome centered at i expands past right,
            // adjust center and right boundaries
            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }
            // Count the palindromes found at index i
            count += (dp[i] + 1) / 2;
        }
        return count;
    }
}
