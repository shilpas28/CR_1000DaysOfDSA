//Leetcode
//1639. Number of Ways to Form a Target String Given a Dictionary
//Time complexity: O(w*n + n*m) where w = number of words, n = word length, m = target length
//Space complexity: O(m + n*26) where m = target length, n = word length 

package Leetcode;

public class NumberOfWaysToFormATargetStringGivenADictionary {

    public static void main(String[] args) {
        String[] words = { "acca", "bbbb", "caca" };
        String target = "aba";
        System.out.println(numWays(words, target));
    }

    public static int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();
        int mod = 1000000007;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        int[][] count = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                dp[j + 1] += (int) ((long) dp[j] * count[i][target.charAt(j) - 'a'] % mod);
                dp[j + 1] %= mod;
            }
        }
        return dp[m];
    }
}
