//Leetcode
//2461. Maximum Sum of Distinct Subarrays With Length K - Brute Force - Not accepted as TLE 
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;

            for (int j = i; j < i + k && j < n; j++) {
                if (set.add(nums[j]) == false) {
                    break;
                }
                sum += nums[j];
            }

            if (set.size() == k)
                max = Math.max(sum, max);
        }
        return max;
    }
}
