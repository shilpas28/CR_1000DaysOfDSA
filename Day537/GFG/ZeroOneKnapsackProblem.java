//GFG
//0 - 1 Knapsack Problem - Memoization
//Time complexity: O(N*W) - There are N*W states therefore at max ‘N*W’ new problems will be solved.
//Space complexity: O(N*W) + O(N) - We are using a recursion stack space(O(N)) and a 2D array ( O(N*W)).

import java.util.Arrays;

public class ZeroOneKnapsackProblem {

    public static void main(String[] args) {
        int W = 4;
        int val[] = { 1, 2, 3 }, wt[] = { 4, 5, 1 };
        System.out.println(knapSack(W, wt, val));
    }

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int n = wt.length;
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[n][W + 1];
        // Initialize the DP array with -1 to indicate that subproblems are not solved
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        // Call the recursive knapsackUtil function to solve the problem
        return knapsackUtil(wt, val, n - 1, W, dp);
    }

    // Helper function to solve the knapsack problem recursively
    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: If there are no items or the knapsack capacity is zero
        if (ind == 0) {
            if (wt[0] <= W) {
                // Include the item if its weight is within the capacity
                return val[0];
            } else {
                // Otherwise, exclude the item
                return 0;
            }
        }
        // If the result for this subproblem is already calculated, return it
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }
        // Calculate the maximum value when the current item is not taken
        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);
        // Calculate the maximum value when the current item is taken
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);
        }
        // Store and return the result for the current state
        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }

}
