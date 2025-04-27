//Leetcode
//3392. Count Subarrays of Length Three With a Condition
//Time complexity: O(N)
//Space complexity: O(1)

public class CountSubarraysOfLengthThreeWithACondition {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 4, 1 };
        System.out.println(countSubarrays(nums));
    }

    public static int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++ans;
            }
        }
        return ans;
    }
}
