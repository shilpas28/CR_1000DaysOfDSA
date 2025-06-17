//Leetcode
//3405. Count the Number of Arrays with K Matching Adjacent Elements
//Time complexity: O(log(n)) + O(k * log MOD) ≈ O(k * log MOD)
//Space complexity: O(1)

public class CountTheNumberOfArraysWithKMatchingAdjacentElements {

    public static void main(String[] args) {
        int n = 3, m = 2, k = 1;
        System.out.println(countGoodArrays(n, m, k));
    }

    static final int MOD = 1_000_000_007;

    public static int countGoodArrays(int n, int m, int k) {
        long formula = m * binExpo(m - 1, n - (k + 1)) % MOD;
        long updatedFormula = formula * nCr(n - 1, k) % MOD;
        return (int) updatedFormula;
    }

    static long binExpo(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                result = result * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }

    static int nCr(int n, int r) {
        if (r > n)
            return 0;
        if (r == 0 || r == n)
            return 1;

        long res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) % MOD;
            res = res * modInverse(i, MOD) % MOD;
        }

        return (int) res;
    }

    static long modInverse(long a, long mod) {
        long res = 1;
        long power = mod - 2;

        while (power > 0) {
            if ((power & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            power >>= 1;
        }

        return res;
    }
}
