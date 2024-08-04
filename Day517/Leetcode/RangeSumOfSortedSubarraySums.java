//Leetcode
//1508. Range Sum of Sorted Subarray Sums - Brute Force
//Time complexity: O(n^2 * log(n^2))
//Space complexity: O(n^2)

package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }

    static final int MOD = 1000000007;

    public static int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        Collections.sort(subarraySums);
        long rangeSum = 0;
        for (int i = left - 1; i < right; i++) {
            rangeSum = (rangeSum + subarraySums.get(i)) % MOD;
        }
        return (int) rangeSum;
    }
}
