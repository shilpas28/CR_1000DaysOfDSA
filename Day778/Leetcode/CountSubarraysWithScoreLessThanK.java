//Leetcode
//2302. Count Subarrays With Score Less Than K - Brute Force - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class CountSubarraysWithScoreLessThanK {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 3, 5 };
        int k = 10;
        System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, long k) {
        long count = 0;
        for (int right = 0; right < nums.length; right++) {
            long sum = 0;
            for (int left = right; left < nums.length; left++) {
                sum += nums[left];
                if (sum * (left - right + 1) < k) {
                    count++;
                }
            }
        }
        return count;
    }
}
