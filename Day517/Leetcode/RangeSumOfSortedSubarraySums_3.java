//Leetcode
//1508. Range Sum of Sorted Subarray Sums - Priority Queue
//Time complexity: O(right * log n)
//Space complexity: O(n)

package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RangeSumOfSortedSubarraySums_3 {

    static class SubarraySum {
        int sum;
        int start;
        int end;

        SubarraySum(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }

    static final int MOD = 1000000007;

    public static int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<SubarraySum> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));

        for (int i = 0; i < n; i++) {
            pq.offer(new SubarraySum(nums[i], i, i));
        }

        long result = 0;
        for (int i = 1; i <= right; i++) {
            SubarraySum current = pq.poll();
            if (i >= left) {
                result = (result + current.sum) % MOD;
            }
            if (current.end < n - 1) {
                current.sum += nums[++current.end];
                pq.offer(current);
            }
        }
        return (int) result;
    }

}
