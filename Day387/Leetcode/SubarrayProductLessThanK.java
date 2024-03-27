//Leetcode
//713. Subarray Product Less Than K
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int left = 0, right = 0, product = 1, count = 0;
        int n = nums.length;

        while (right < n) {
            product *= nums[right];
            while (product >= k)
                product /= nums[left++];
            count += 1 + (right - left);
            right++;
        }
        return count;
    }
}
