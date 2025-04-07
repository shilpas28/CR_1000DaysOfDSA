//Leetcode
//416. Partition Equal Subset Sum - Memoization/Top down
//Time complexity: O(N*K) + O(N) - There are N*K states therefore at max N*K new problems will be solved 
//and we are running a for loop for N times to calculate the total sum
//Space complexity: O(N*K) + O(N) - We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).

package Leetcode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        if (totSum % 2 == 1)
            return false;
        else {
            int k = totSum / 2;
            int dp[][] = new int[n][k + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);
            return subsetSumUtil(n - 1, k, nums, dp);
        }
    }

    static boolean subsetSumUtil(int ind, int target, int arr[], int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
}
