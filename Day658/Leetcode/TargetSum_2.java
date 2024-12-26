//Leetcode
//494. Target Sum - Tabulation/Bottom up
//Time complexity: O(N*K) - There are two nested loops
//Space complexity: O(N*K) - We are using an external array of size N*K. Stack Space is eliminated. 

package Leetcode;

public class TargetSum_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }
        // Checking for edge cases
        if (totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;

        return findWays(nums, (totSum - target) / 2);
    }

    static int mod = (int) (Math.pow(10, 9) + 7);

    static int findWays(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];

        if (num[0] == 0)
            dp[0][0] = 2; // 2 cases -pick and not pick
        else
            dp[0][0] = 1; // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar)
            dp[0][num[0]] = 1; // 1 case -pick

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {

                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = dp[ind - 1][target - num[ind]];

                dp[ind][target] = (notTaken + taken) % mod;
            }
        }
        return dp[n - 1][tar];
    }
}
