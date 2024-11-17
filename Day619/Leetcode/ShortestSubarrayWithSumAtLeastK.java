//Leetcode
//862. Shortest Subarray with Sum at Least K - Sliding windows + Monotonic Deque
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    // Helper class to store pairs
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, -1, 2 };
        int k = 3;
        System.out.println(shortestSubarray(nums, k));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        long curSum = 0;
        Deque<Pair<Long, Integer>> q = new ArrayDeque<>(); // (prefix_sum, end_idx)

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];

            if (curSum >= k) {
                res = Math.min(res, r + 1);
            }
            // Find the minimum valid window ending at r
            while (!q.isEmpty() && curSum - q.peekFirst().getKey() >= k) {
                Pair<Long, Integer> front = q.pollFirst();
                res = Math.min(res, r - front.getValue());
            }
            // Validate the monotonic deque
            while (!q.isEmpty() && q.peekLast().getKey() > curSum) {
                q.pollLast();
            }
            q.offerLast(new Pair<>(curSum, r));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
