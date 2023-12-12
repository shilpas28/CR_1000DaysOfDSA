//Leetcode
//1464. Maximum Product of Two Elements in an Array - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ans;
    }
}
