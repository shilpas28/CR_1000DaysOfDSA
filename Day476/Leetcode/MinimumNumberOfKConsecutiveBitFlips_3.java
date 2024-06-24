//Leetcode
//995. Minimum Number of K Consecutive Bit Flips
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

public class MinimumNumberOfKConsecutiveBitFlips_3 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        int k = 1;
        System.out.println(minKBitFlips(nums, k));
    }

    public static int minKBitFlips(int[] nums, int k) {
        int ans = 0, flips = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] + flips) % 2 == 0) {
                if (i > nums.length - k) {
                    return -1;
                } else {
                    ans++;
                    flips++;
                    nums[i] = -1;
                }
            }
            if (i + 1 >= k) {
                flips -= (nums[i - k + 1] < 0 ? 1 : 0);
            }
        }
        return ans;
    }
}
