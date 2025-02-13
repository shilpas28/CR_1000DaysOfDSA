//Leetcode
//3066. Minimum Operations to Exceed Threshold Value II
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {

    public static void main(String[] args) {
        int[] nums = { 2, 11, 10, 1, 3 };
        int k = 10;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        long cnt = 0;
        while (pq.peek() < k) {
            long first = pq.poll();
            long second = pq.poll();
            long num = 2 * Math.min(first, second) + Math.max(first, second);
            pq.add(num);
            cnt++;
        }
        return (int) cnt;
    }
}
