//Leetcode
//1695. Maximum Erasure Value - Prefix Sum Solution
//Time complexity: O(n)
//Space complexity: O(n) 

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue_2 {

    public static void main(String[] args) {
        int[] nums = { 4, 2, 4, 5, 6 };
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];

        int maxScore = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            prefixSum[r + 1] = prefixSum[r] + nums[r];
            if (lastIndex.containsKey(nums[r]))
                l = Math.max(l, lastIndex.get(nums[r]) + 1);
            maxScore = Math.max(maxScore, prefixSum[r + 1] - prefixSum[l]);
            lastIndex.put(nums[r], r);
        }
        return maxScore;
    }
}
