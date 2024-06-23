//Leetcode
//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit - Use TreeMap
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_2 {

    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 4, 7, 2 };
        int limit = 5;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < nums.length; j++) {
            m.put(nums[j], 1 + m.getOrDefault(nums[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(nums[i], m.get(nums[i]) - 1);
                if (m.get(nums[i]) == 0)
                    m.remove(nums[i]);
                i++;
            }
        }
        return j - i;
    }
}
