//Leetcode
//198. House Robber - Iterative + 2 variables (bottom-up)
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class HouseRobber_4 {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
