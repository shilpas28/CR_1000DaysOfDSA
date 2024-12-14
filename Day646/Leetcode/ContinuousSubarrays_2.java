//Leetcode
//2762. Continuous Subarrays - Priority Queue
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.PriorityQueue;

public class ContinuousSubarrays_2 {

    public static void main(String[] args) {
        int[] nums = { 5, 4, 2, 4 };
        System.out.println(continuousSubarrays(nums));
    }

    public static long continuousSubarrays(int[] nums) {

        int left = 0, right = 0;
        long count = 0; // Total count of valid subarrays
        // Min and max heaps storing indices, sorted by nums[index] values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> nums[a] - nums[b]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> nums[b] - nums[a]);

        while (right < nums.length) {
            // Add current index to both heaps
            minHeap.add(right);
            maxHeap.add(right);
            // While window violates |nums[i] - nums[j]| ≤ 2 condition
            // Shrink window from left and remove outdated indices
            while (left < right && nums[maxHeap.peek()] - nums[minHeap.peek()] > 2) {
                left++;
                // Remove indices that are now outside window
                while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek() < left) {
                    minHeap.poll();
                }
            }
            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
