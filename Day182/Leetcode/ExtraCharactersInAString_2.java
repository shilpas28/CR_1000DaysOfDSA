//leetcode
//2707. Extra Characters in a String - Tabulation/Bottom up
//Time complexity: O(NML) - Where N is the length of the input string s, M is the number of words in the dictionary, 
//and L is the average length of words in the dictionary.
//Space complexity: O(N) - Where N is the length of the input string s. We use an array dp of size N 
//to store the minimum extra characters at each position.

package Leetcode;

public class ExtraCharactersInAString_2 {

    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = { "leet", "code", "leetcode" };
        System.out.println(minExtraChar(s, dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[51]; // Initialize an array to store the minimum extra characters.
        int n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = 1 + dp[i + 1]; // Initialize with one extra character.
            for (String w : dictionary) {
                if (i + w.length() <= n && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = Math.min(dp[i], dp[i + w.length()]); // Update if a word in the dictionary is found.
                }
            }
        }
        return dp[0]; // Return the minimum extra characters for the entire string.
    }
}
