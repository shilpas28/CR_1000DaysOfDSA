//Leetcode
//1508. Range Sum of Sorted Subarray Sums - Counting Sort 
//Time complexity: O(n^2 + m)
//Space complexity: O(m)

package Leetcode;

public class RangeSumOfSortedSubarraySums_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }

    static final int MOD = 1000000007;

    public static int rangeSum(int[] nums, int n, int left, int right) {
        // Find the maximum possible sum
        int maxSum = 0;
        for (int num : nums) {
            maxSum += num;
        }
        // Count the frequency of each sum
        int[] count = new int[maxSum + 1];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                count[sum]++;
            }
        }
        // Calculate prefix sum of frequencies
        for (int i = 1; i <= maxSum; i++) {
            count[i] += count[i - 1];
        }

        long result = 0;
        for (int sum = 1, k = 1; sum <= maxSum; sum++) {
            while (k <= count[sum]) {
                if (k >= left && k <= right) {
                    result = (result + sum) % MOD;
                }
                k++;
            }
        }
        return (int) result;
    }
}
