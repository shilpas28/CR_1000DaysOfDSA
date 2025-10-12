//Leetcode
//3539. Find Sum of Array Product of Magical Sequences
//Time complexity: O(N*M^3*K)
//Space complexity: O(N*M^2*K)

public class FindSumOfArrayProductOfMagicalSequences {

    public static void main(String[] args) {
        int m = 5, k = 5;
        int[] nums = { 1, 10, 100, 10000, 1000000 };
        System.out.println(magicalSum(m, k, nums));
    }

    public static int magicalSum(int m, int k, int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;

        long[] f = new long[m + 1];
        long[] inverse_f = new long[m + 1];
        f[0] = 1;
        for (int i = 1; i <= m; i++) {
            f[i] = f[i - 1] * i % MOD;
        }

        inverse_f[m] = modPow(f[m], MOD - 2, MOD);
        for (int i = m; i >= 1; i--) {
            inverse_f[i - 1] = inverse_f[i] * i % MOD;
        }

        long[][] pow_nums = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            pow_nums[i][0] = 1;
            for (int c = 1; c <= m; c++) {
                pow_nums[i][c] = pow_nums[i][c - 1] * nums[i] % MOD;
            }
        }

        long[][][][] dp = new long[n + 1][m + 1][k + 1][m + 1];
        dp[0][0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int m1 = 0; m1 <= m; m1++) {
                for (int k1 = 0; k1 <= k; k1++) {
                    for (int m2 = 0; m2 <= m; m2++) {
                        long val = dp[i][m1][k1][m2];
                        if (val == 0)
                            continue;
                        for (int c = 0; c <= m - m1; c++) {
                            int m12 = m1 + c;
                            int s = c + m2;
                            int bit = s & 1;
                            int k2 = k1 + bit;
                            if (k2 > k)
                                continue;
                            int m22 = s >> 1;
                            dp[i + 1][m12][k2][m22] = (dp[i + 1][m12][k2][m22]
                                    + val * inverse_f[c] % MOD * pow_nums[i][c] % MOD) % MOD;
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (int k1 = 0; k1 <= k; k1++) {
            for (int m2 = 0; m2 <= m; m2++) {
                long val = dp[n][m][k1][m2];
                if (val == 0)
                    continue;
                int bits = Integer.bitCount(m2);
                if (k1 + bits == k) {
                    ans = (ans + val) % MOD;
                }
            }
        }

        ans = ans * f[m] % MOD;
        return (int) ans;
    }

    static long modPow(long a, long e, int mod) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) != 0)
                res = res * a % mod;
            a = a * a % mod;
            e >>= 1;
        }
        return res;
    }
}
