//Leetcode
//1508. Range Sum of Sorted Subarray Sums - Sliding Window
//Time complexity: O(n * log(sum))
//Space complexity: O(1)

package Leetcode;

import java.util.AbstractMap;
import java.util.Map;

public class RangeSumOfSortedSubarraySums_4 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }

    static final int MODULUS = 1000000007;
    static long maxSubarraySum = 0;
    static long minSubarraySum = 0;

    public static int rangeSum(int[] nums, int n, int left, int right) {
        minSubarraySum = nums[0];
        for (int num : nums) {
            maxSubarraySum += num;
            minSubarraySum = Math.min(minSubarraySum, num);
        }

        long result = (calculateSumOfFirstKSubarrays(nums, right) % MODULUS -
                calculateSumOfFirstKSubarrays(nums, left - 1) % MODULUS +
                MODULUS) % MODULUS;
        return (int) result;
    }

    static long calculateSumOfFirstKSubarrays(int[] array, int k) {
        long low = minSubarraySum, high = maxSubarraySum;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countAndSumSubarrays(array, mid).getKey() < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        Map.Entry<Integer, Long> result = countAndSumSubarrays(array, low);
        long sum = result.getValue();
        int count = result.getKey();
        return sum - low * (count - k);
    }

    static Map.Entry<Integer, Long> countAndSumSubarrays(int[] array, long threshold) {
        int count = 0;
        long totalSum = 0;
        long currentWindowSum = 0;
        long runningSum = 0;
        int size = array.length;

        for (int start = 0, end = 0; end < size; ++end) {
            runningSum += (long) array[end] * (end - start + 1);
            currentWindowSum += array[end];
            while (currentWindowSum > threshold) {
                runningSum -= currentWindowSum;
                currentWindowSum -= array[start++];
            }
            count += end - start + 1;
            totalSum += runningSum;
        }
        return new AbstractMap.SimpleEntry<>(count, totalSum);
    }
}
