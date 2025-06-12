//Leetcode
//3423. Maximum Difference Between Adjacent Elements in a Circular Array
//Time complexity: O(N)
//Space complexity: O(1) 

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };
        System.out.println(maxAdjacentDistance(nums));
    }

    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; ++i) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }
}
