//Leetcode
//2444. Count Subarrays With Fixed Bounds
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CountSubarraysWithFixedBounds {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2, 7, 5 };
        int minK = 1, maxK = 5;
        System.out.println(countSubarrays(nums, minK, maxK));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int leftBound = -1;
        int lastMin = -1;
        int lastMax = -1;
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= minK && nums[i] <= maxK) {
                lastMin = (nums[i] == minK) ? i : lastMin;
                lastMax = (nums[i] == maxK) ? i : lastMax;
                count += Math.max(0, Math.min(lastMin, lastMax) - leftBound);
            } else {
                leftBound = i;
                lastMin = -1;
                lastMax = -1;
            }
        }
        return count;
    }
}
