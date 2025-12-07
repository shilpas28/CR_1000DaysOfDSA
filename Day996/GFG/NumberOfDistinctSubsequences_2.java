//GFG
//Number of distinct subsequences
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashMap;

public class NumberOfDistinctSubsequences_2 {

    public static void main(String[] args) {
        String str = "gfg";
        System.out.println(distinctSubseq(str));
    }

    static int distinctSubseq(String str) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;
            char curr = str.charAt(i - 1);
            if (map.containsKey(curr)) {
                dp[i] = (dp[i] - dp[map.get(curr) - 1] + mod) % mod;
            }

            map.put(curr, i);
        }
        return dp[n];
    }
}
