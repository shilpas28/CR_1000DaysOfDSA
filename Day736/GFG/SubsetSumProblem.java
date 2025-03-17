//GFG
//Subset Sum Problem - Memoization
//Time complexity: O(N*K)
//Space complexity: O(N*K) + O(N)

import java.util.Arrays;

public class SubsetSumProblem {

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum));
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][sum + 1];
        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);
        // Call the recursive helper function
        return subsetSumUtil(n - 1, sum, arr, dp);
    }

    // Helper function to solve subset sum problem using dynamic programming
    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // If the target sum is achieved, return true
        if (target == 0)
            return true;
        // If we have considered all elements but haven't reached the target, return
        // false
        if (ind == 0)
            return arr[0] == target;
        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;
        // Try not taking the current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);
        // Try taking the current element if it doesn't exceed the target
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        // Store the result in the DP table and return whether either option was
        // successful
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
}
