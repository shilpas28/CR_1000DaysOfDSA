//Leetcode
//3578. Count Partitions With Max-Min Difference at Most K - Monotonic Queue Optimization
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Deque;
import java.util.LinkedList;

public class CountPartitionsWithMaxMinDifferenceAtMostK_2 {

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 3, 7};
        int k = 4;
        System.out.println(countPartitions(nums, k));
    }

    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            // maintain the maximum value queue
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            // maintain the minimum value queue
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }
            minQ.offerLast(i);
            // adjust window
            while (!maxQ.isEmpty()
                    && !minQ.isEmpty()
                    && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == j) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() == j) {
                    minQ.pollFirst();
                }
                j++;
            }

            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
}
