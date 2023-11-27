//Leetcode
//935. Knight Dialer
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class KnightDialer_2 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(knightDialer(n));
    }

    public static int knightDialer(int n) {
        final int MOD = 1_000_000_007;
        int[][] moves = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 },
                { 2, 4 } };
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int next : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
                }
            }
        }

        int result = 0;
        for (int count : dp[n - 1]) {
            result = (result + count) % MOD;
        }

        return result;
    }
}
