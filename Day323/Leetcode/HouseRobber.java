//Leetcode - Not accepted as TLE
//198. House Robber - Recursive (top-down)
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    static int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }
}
