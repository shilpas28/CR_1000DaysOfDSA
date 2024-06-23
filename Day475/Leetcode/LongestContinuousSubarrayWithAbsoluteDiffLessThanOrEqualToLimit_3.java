//Leetcode
//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit - Use two deques
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_3 {

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 4, 7, 2 };
        int limit = 5;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < nums.length; ++j) {
            while (!maxd.isEmpty() && nums[j] > maxd.peekLast())
                maxd.pollLast();
            while (!mind.isEmpty() && nums[j] < mind.peekLast())
                mind.pollLast();
            maxd.add(nums[j]);
            mind.add(nums[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[i])
                    maxd.poll();
                if (mind.peek() == nums[i])
                    mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}
