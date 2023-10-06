//Leetcode 
//343. Integer Break - using Memoization/Top down method
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class IntegerBreak_2 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        return helper(n - 1, n, dp);
    }

    static int helper(int n, int total, int dp[]) {
        if (n <= 1)
            return 1;
        int notpick = helper(n - 1, total, dp);
        int pick = 0;
        if (total >= n)
            pick = n * helper(n, total - n, dp);
        return dp[n] = Math.max(pick, notpick);
    }
}
