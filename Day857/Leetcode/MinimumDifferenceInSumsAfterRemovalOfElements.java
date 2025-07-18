//Leetcode
//2163. Minimum Difference in Sums After Removal of Elements
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumDifferenceInSumsAfterRemovalOfElements {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        System.out.println(minimumDifference(nums));
    }

    public static long minimumDifference(int[] nums) {
        int n3 = nums.length;
        int n = n3 / 3;

        long[] leftMin = new long[n3];
        long[] rightMin = new long[n3];
        // Max heap for left part (to remove largest and keep n smallest)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;
        for (int i = 0; i < n3; ++i) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (i >= n - 1) {
                leftMin[i] = leftSum;
            }
        }
        // Min heap for right part (to remove smallest and keep n largest)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = n3 - 1; i >= 0; --i) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (i <= n3 - n) {
                rightMin[i] = rightSum;
            }
        }
        // Calculate minimum difference
        long result = Long.MAX_VALUE;
        for (int i = n - 1; i <= n3 - n - 1; ++i) {
            result = Math.min(result, leftMin[i] - rightMin[i + 1]);
        }
        return result;
    }
}
