//Leetcode
//2302. Count Subarrays With Score Less Than K - Sliding Window
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CountSubarraysWithScoreLessThanK_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 3, 5 };
        int k = 10;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, long k) {
        long count = 0, sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            count += (right - left + 1);
        }
        return count;
    }
}
