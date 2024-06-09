//Leetcode
//974. Subarray Sums Divisible by K - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        // Iterate through all possible subarrays
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                // Check if the sum is divisible by k
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
