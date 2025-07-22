//Leetcode
//1695. Maximum Erasure Value - Two-pointer Solution
//Time complexity: O(n)
//Space complexity: O(m) where m is the number of unique elements.

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static void main(String[] args) {
        int[] nums = { 4, 2, 4, 5, 6 };
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0, currScore = 0;
        Set<Integer> set = new HashSet<>();

        for (int l = 0, r = 0; r < nums.length; r++) {
            while (!set.add(nums[r])) {
                currScore -= nums[l];
                set.remove(nums[l++]);
            }
            currScore += nums[r];
            maxScore = Math.max(maxScore, currScore);
        }
        return maxScore;
    }
}
