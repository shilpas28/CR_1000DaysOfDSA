//Leetcode
//279. Perfect Squares - Top Down DP (Recursion + Memoization)
//Time complexity: O(N * sqrt(N))
//Space complexity: O(N)

package Leetcode;

public class PerfectSquares_2 {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    public static int helper(int n, int[] memo) {
        if (n < 4)
            return n;

        if (memo[n] != 0)
            return memo[n];
        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }
        return memo[n] = ans;
    }
}
