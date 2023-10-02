//GFG 
//Number of distinct subsequences 
//Time complexity: O(|str|)
//Space complexity: O(|str|)

import java.util.HashMap;

public class NumberOfDistinctSubsequences_3 {

    public static void main(String[] args) {
        String s = "gfg";
        System.out.println(distinctSubsequences(s));
    }

    static int distinctSubsequences(String S) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int n = S.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;
            char curr = S.charAt(i - 1);
            if (map.containsKey(curr))
                dp[i] = (dp[i] - dp[map.get(curr) - 1] + mod) % mod;

            map.put(curr, i);
        }
        return dp[n];
    }
}
