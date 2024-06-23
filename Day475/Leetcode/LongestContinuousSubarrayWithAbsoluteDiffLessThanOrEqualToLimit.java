//Leetcode
//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit - Use two heaps
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Collections;
import java.util.PriorityQueue;

@SuppressWarnings("all")
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 4, 7, 2 };
        int limit = 5;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 0;
        int res = 1;
        boolean t, tt;

        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        while (start <= end && end < nums.length) {
            minQ.offer(nums[end]);
            maxQ.offer(nums[end]);
            int minNum = minQ.peek();
            int maxNum = maxQ.peek();
            if (maxNum - minNum <= limit) {
                end++;
                res = Math.max(res, end - start);
            } else {
                t = minQ.remove(nums[start]);
                tt = maxQ.remove(nums[start]);
                start++;
                end++; // When ">limit" you also need to change your end, if you do not do so, you will
                       // push the same number twice.
            }
        }
        return res;
    }
}
