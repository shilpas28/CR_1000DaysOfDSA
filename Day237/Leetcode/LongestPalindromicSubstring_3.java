//Leetcode
//5. Longest Palindromic Substring - Optimal method
//Time complexity: The code uses a two-pointer approach to expand around each center, resulting in a linear time complexity 
//of O(n), where n is the length of the string.
//Space complexity: The code uses a constant amount of extra space, resulting in a space complexity of O(1).

package Leetcode;

public class LongestPalindromicSubstring_3 {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return "";
        if (n == 1)
            return s;

        int minstart = 0, maxlen = 0;

        for (int i = 0; i < n;) {
            if (n - i < maxlen / 2)
                break;

            int l = i, r = i;
            // Find the center of the palindrome
            while (r < n - 1 && s.charAt(r) == s.charAt(r + 1))
                r++;
            // Update the next starting point
            i = r + 1;
            // Expand around the center to find the longest palindrome
            while (l > 0 && r < n - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }

            int newlen = r - l + 1;
            if (newlen > maxlen) {
                maxlen = newlen;
                minstart = l;
            }
        }

        return s.substring(minstart, minstart + maxlen);
    }
}
