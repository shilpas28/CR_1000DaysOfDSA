//Leetcode
//2448. Minimum Cost to Make Array Equal
//Time complexity: O(nlog(a)), where a is the range of A[i]
//Space complexity: O(1)

package Leetcode;

public class MinimumCostToMakeArrayEqual {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2 };
        int[] cost = { 2, 3, 1, 14 };
        System.out.println(minCost(nums, cost));
    }

    public static long minCost(int[] nums, int[] cost) {
        long left = 1L;
        long right = 1000000L;
        for (int num : nums) {
            left = Math.min(num, left);
            right = Math.max(num, right);
        }
        long ans = findCost(nums, cost, 1);
        while (left < right) {
            long mid = (left + right) / 2;
            long y1 = findCost(nums, cost, mid);
            long y2 = findCost(nums, cost, mid + 1);
            ans = Math.min(y1, y2);
            if (y1 < y2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static long findCost(int[] nums, int[] cost, long x) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - x) * cost[i];
        }
        return res;
    }
}
