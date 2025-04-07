//Leetcode
//416. Partition Equal Subset Sum - Space optimization
//Time complexity: O(N*K) +O(N) - There are two nested loops that account for O(N*K) 
//and at starting we are running a for loop to calculate totSum.
//Space complexity: O(K) - We are using an external array of size K+1 to store only one row.

package Leetcode;

public class PartitionEqualSubsetSum_3 {

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
            boolean prev[] = new boolean[k + 1];

            prev[0] = true;

            if (nums[0] <= k)
                prev[nums[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];

                    boolean taken = false;
                    if (nums[ind] <= target)
                        taken = prev[target - nums[ind]];

                    cur[target] = notTaken || taken;
                }
                prev = cur;
            }
            return prev[k];
        }
    }
}
