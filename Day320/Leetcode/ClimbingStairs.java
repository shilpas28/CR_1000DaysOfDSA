//Leetcode - Memoization/Top Down
//70. Climbing Stairs - very Similar to Fibonaaci except the base case (both are 1s)
//Time complexity: O(N) - The overlapping subproblems will return the answer in constant time O(1). Therefore the total number 
//of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
//Space complexity: O(N) - We are using a recursion stack space(O(N)) and an array (again O(N)). Therefore total space complexity 
//will be O(N) + O(N) ≈ O(N)

package Leetcode;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    static int f(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }

}
