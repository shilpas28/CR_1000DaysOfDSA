//Leetcode - Tabulation/Bottom Up
//70. Climbing Stairs - very Similar to Fibonaaci except the base case (both are 1s)
//Time complexity: O(N) - We are running a simple iterative loop
//Space complexity: O(N) - We are using an external array of size ‘n+1’

package Leetcode;

import java.util.Arrays;

public class ClimbingStairs_2 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
