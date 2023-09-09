//Leetcode 
//377. Combination Sum IV - DP solution(Memoization/Top down)
//Time complexity: O(N^2)
//Space complexity: O(N) + O(N) - DP array and recursive stack space

package Leetcode;

import java.util.Arrays;

public class CombinationSumIV_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }

    static int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i], dp);
            }
        }
        dp[target] = res;
        return res;
    }
}
