//Leetcode
//647. Palindromic Substrings - DP (Break into Even and Odd)
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class PalindromicSubstrings_3 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    static int count = 0;

    public static int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            help(s, i, i);
            help(s, i, i + 1);
        }
        return count;
    }

    static void help(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
