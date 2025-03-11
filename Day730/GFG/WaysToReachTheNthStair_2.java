//GFG
//Ways to Reach the n'th Stair - Memoization
//Time complexity: O(N), where N is the given number of stairs. This is because we perform a linear number of operations relative 
//to the input size n.
//Space complexity: O(N) - O(N)+O(N), We are using a recursion stack space O(N) and an array (again O(N)). Therefore total space 
//complexity will be O(N) + O(N) ≈ O(N).

import java.util.Arrays;

public class WaysToReachTheNthStair_2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n));
    }

    static int countWays(int n) {
        // your code here
        int[] dp = new int[n + 1];
        // Initialize dp array with -1
        Arrays.fill(dp, -1);
        // Return the calculated value
        return dp[n] = func(n, dp);
    }

    // Helper function to apply memoization
    static int func(int n, int dp[]) {
        // Base condition
        if (n <= 1) {
            return 1;
        }
        // Check if the subproblem is already solved
        if (dp[n] != -1) {
            return dp[n];
        }
        // Return the calculated value
        return dp[n] = func(n - 1, dp) + func(n - 2, dp);
    }
}
