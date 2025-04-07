//Leetcode
//416. Partition Equal Subset Sum - Tabulation/Bottom up
//Time complexity: O(N*K) + O(N) - There are two nested loops that account for O(N*K) and at starting 
//we are running a for loop to calculate totSum.
//Space complexity: O(N*K) - We are using an external array of size N*K. Stack Space is eliminated.

package Leetcode;

public class PartitionEqualSubsetSum_2 {

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
            boolean dp[][] = new boolean[n][k + 1];

            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            if (nums[0] <= k)
                dp[0][nums[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {

                    boolean notTaken = dp[ind - 1][target];

                    boolean taken = false;
                    if (nums[ind] <= target)
                        taken = dp[ind - 1][target - nums[ind]];

                    dp[ind][target] = notTaken || taken;
                }
            }
            return dp[n - 1][k];
        }
    }
}
