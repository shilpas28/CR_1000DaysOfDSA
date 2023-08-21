//Leetcode
//459. Repeated Substring Pattern - using KMP alogorithm
//Time complexity: O(N+M) where N is the length of the text and M is the length of the pattern to be found.
//Space complexity: O(M)

package Leetcode;

public class RepeatedSubstringPattern_2 {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; ++i) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = lps[j - 1];
            if (s.charAt(i) == s.charAt(j))
                ++j;
            lps[i] = j;
        }
        int l = lps[n - 1];
        return (l != 0) && (l % (n - l) == 0);
    }
}
