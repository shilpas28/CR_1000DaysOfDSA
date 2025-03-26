//GFG
//Word Break 
//Time complexity: O(n*m)
//Space complexity: O(n)

import java.util.Arrays;
import java.util.HashSet;

public class WordBreak_4 {

    public static void main(String[] args) {
        String s = "ilike";
        String dictionary[] = { "i", "like", "gfg" };
        System.out.println(wordBreak(s, dictionary));
    }

    public static boolean wordBreak(String s, String[] dictionary) {
        // code here
        int n = s.length();
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int maxWordLength = 0;
        for (String word : dictionary) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(i - maxWordLength, 0); j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
