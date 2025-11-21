//Leetcode
//1930. Unique Length-3 Palindromic Subsequences
//Time complexity: O(N) - The solution iterates through the string once for each character, and the inner loop iterates through
//the characters between the first and last occurrences.
//Sapce complexity: O(1) - The solution uses a constant amount of space for the boolean array v and some variables, independent 
//of the input size.

import java.util.Arrays;

public class UniqueLength3PalindromicSubsequences {

    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        char[] c = s.toCharArray();
        boolean[] v = new boolean[128];
        int a = 0, t;

        int l, r;
        for (char x = 'a'; x <= 'z'; x++) {
            for (l = 0; l < c.length && c[l] != x; l++) {
                if (l == c.length) {
                    continue;
                }
            }

            for (r = c.length - 1; r >= 0 && c[r] != x; r--) {
                if (l >= r) {
                    continue;
                }
            }

            Arrays.fill(v, false);
            t = 0;
            for (int i = l + 1; i < r; i++) {
                if (!v[c[i]]) {
                    v[c[i]] = true;
                    t++;
                    if (t == 26) {
                        break;
                    }
                }
            }
            a += t;
        }
        return a;
    }
}
