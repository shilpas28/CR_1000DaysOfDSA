//Leetcode
//5. Longest Palindromic Substring - Brute force method - Not accepted as TLE
//Time complexity: The time complexity of the above solution is O(n^3) because we have two nested loops and for each substring, 
//we check whether it's a palindrome or not using another loop. In the worst case, the check function will be called for each 
//substring, which takes O(n) time, making the overall time complexity O(n^3).
//Space complexity: The space complexity of the solution is O(1) because we are not using any additional space apart from a few 
//integer variables to keep track of the longest palindromic substring seen so far.

package Leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int starting_index = 0;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    if (j - i + 1 > max_len) {
                        max_len = j - i + 1;
                        starting_index = i;
                    }
                }
            }
        }
        return s.substring(starting_index, starting_index + max_len);
    }

    public static boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
