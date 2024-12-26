//Leetcode
//494. Target Sum - Space optimization
//Time complexity: O(N*K) - There are three nested loops
//Space complexity: O(K) - We are using an external array of size K to store only one row.

package Leetcode;

public class TargetSum_3 {

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
        int prev[] = new int[tar + 1];

        if (num[0] == 0)
            prev[0] = 2; // 2 cases -pick and not pick
        else
            prev[0] = 1; // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar)
            prev[num[0]] = 1; // 1 case -pick

        for (int ind = 1; ind < n; ind++) {
            int cur[] = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = prev[target - num[ind]];

                cur[target] = (notTaken + taken) % mod;
            }
            prev = cur;
        }
        return prev[tar];
    }
}
