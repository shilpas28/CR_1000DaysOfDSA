//Leetcode
//1137. N-th Tribonacci Number - Iterative Approach (Dynamic Programming)
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NthTribonacciNumber_3 {

    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
