//Leetcode
//2461. Maximum Sum of Distinct Subarrays With Length K - Sliding Window #3
//Time complexity: O(N)
//Space complexity: O(k)

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithLengthK_4 {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> prevIdx = new HashMap<>();
        long curSum = 0;

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];

            int i = prevIdx.getOrDefault(nums[r], -1);

            while (l <= i || r - l + 1 > k) {
                curSum -= nums[l];
                l++;
            }

            if (r - l + 1 == k)
                res = Math.max(res, curSum);

            prevIdx.put(nums[r], r);
        }
        return res;
    }
}
