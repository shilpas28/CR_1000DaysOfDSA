//Leetcode
//2762. Continuous Subarrays - Sorted Map
//Time complexity: O(nlogk) ≈ O(n)
//Space complexity: O(k) ≈ O(1)

import java.util.TreeMap;

public class ContinuousSubarrays {

    public static void main(String[] args) {
        int[] nums = { 5, 4, 2, 4 };
        System.out.println(continuousSubarrays(nums));
    }

    public static long continuousSubarrays(int[] nums) {
        // TreeMap to maintain sorted frequency map of current window
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int left = 0, right = 0;
        int n = nums.length;
        long count = 0; // Total count of valid subarrays

        while (right < n) {
            // Add current element to frequency map
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            // While window violates the condition |nums[i] - nums[j]| ≤ 2
            // Shrink window from left
            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                // Remove leftmost element from frequency map
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
