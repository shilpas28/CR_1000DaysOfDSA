//leetcode
//2707. Extra Characters in a String - Memoization/Top down
//Time complexity: O(NML) - Where N is the length of the input string s, M is the number of words in the dictionary, 
//and L is the average length of words in the dictionary. This is because each position in the string is visited once 
//for each word in the dictionary.
//Space complexity: O(N) - Where N is the length of the input string s. We use an array dp of size N 
//for memoization, and the recursive call stack can go up to a depth of N.

package Leetcode;

import java.util.Arrays;

public class ExtraCharactersInAString {

    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = { "leet", "code", "leetcode" };
        System.out.println(minExtraChar(s, dictionary));
    }

    static int[] dp = new int[51];

    public static int minExtraChar(String s, String[] dictionary) {
        Arrays.fill(dp, -1); // Initialize dp array with -1 values
        return minExtraCharHelper(s, dictionary, 0);
    }

    static int minExtraCharHelper(String s, String[] dictionary, int i) {
        if (i == s.length()) {
            return 0;
        }
        if (dp[i] == -1) {
            dp[i] = 1 + minExtraCharHelper(s, dictionary, i + 1); // Initialize with one extra character
            for (String w : dictionary) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = Math.min(dp[i], minExtraCharHelper(s, dictionary, i + w.length())); // Update if a word in
                                                                                                // the dictionary is
                                                                                                // found
                }
            }
        }
        return dp[i]; // Return the minimum extra characters starting from position i
    }
}
