//Leetcode
//1220. Count Vowels Permutation - Tabulation Approach
//Time complexity: O(6 * 5 * N)
//Space complexity: O(N * 6)

package Leetcode;

import java.util.Arrays;

public class CountVowelsPermutation_3 {
    
    public static void main(String[] args) {
        int n = 1;
        System.out.println(countVowelPermutation(n));
    }

    public static int countVowelPermutation(int n) {
        long MOD = (long)(1e9 + 7);
        long[][] dp = new long[n + 1][6];
        Arrays.fill(dp[0], 1);
        for (int len = 1; len <= n; len++) {
            for (int last = 0; last <= 5; last++) {
                long count = 0;
                if (last == 2)
                    count = (count + dp[len - 1][1]) % MOD;
                if (last == 1 || last == 3)
                    count = (count + dp[len - 1][2]) % MOD;
                if (last == 1 || last == 2 || last == 4 || last == 5)
                    count = (count + dp[len - 1][3]) % MOD;
                if (last == 3 || last == 5)
                    count = (count + dp[len - 1][4]) % MOD;
                if (last == 1)
                    count = (count + dp[len - 1][5]) % MOD;
                if (last == 0)
                    for (int i = 1; i <= 5; i++)
                        count = (count + dp[len - 1][i]) % MOD;

                dp[len][last] = count % MOD;
            }
        }
        return (int)dp[n][0];
    }
}
