//Leetcode
//1509. Minimum Difference Between Largest and Smallest Value in Three Moves
//Time complexity: O(nlogn)
//Space complexity: O(1)

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_2 {

    public static void main(String[] args) {
        int[] nums = { 5, 3, 2, 4 };
        System.out.println(minDifference(nums));
    }

    public static int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int k = nums.length - 3;
        int ans = nums[nums.length - 1] - nums[0];
        for (int i = k - 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }
}
