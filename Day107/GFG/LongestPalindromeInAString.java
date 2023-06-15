//GFG
//Longest Palindrome in a String
//Time complexity: O(|S|2)
//Space complexity: O(1)

package GFG;

public class LongestPalindromeInAString {

    public static void main(String[] args) {
        String S = "aaaabbaa";
        System.out.println(longestPalin(S));
    }

    static String longestPalin(String S) {
        // code here
        int n = S.length();
        int len = 0;
        String ans = "";
        for (int i = 0; i < n; i++) {
            String curr = help(S, i, i); // odd
            if (curr.length() > len) {
                ans = curr;
                len = curr.length();
            }
            curr = help(S, i, i + 1); // even
            if (curr.length() > len) {
                ans = curr;
                len = curr.length();
            }
        }
        return ans;
    }

    static String help(String s, int st, int end) {
        int n = s.length();
        while (st >= 0 && end < n) {
            if (s.charAt(st) == s.charAt(end)) {
                st--;
                end++;
            } else
                break;
        }
        return s.substring(st + 1, end);
    }
}
