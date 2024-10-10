//Leetcode
//962. Maximum Width Ramp - Brute force - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

public class MaximumWidthRamp {

    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        System.out.println(maxWidthRamp(nums));
    }

    public static int maxWidthRamp(int[] nums) {
        int res = 0;
        rightIdx: for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] >= nums[j]) {
                    res = Math.max(res, i - j);
                    continue rightIdx; // stop inner loop at the first valid index j
                }
            }
        }
        return res;
    }
}
