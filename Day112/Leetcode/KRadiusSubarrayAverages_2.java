//Leetcode
//2090. K Radius Subarray Averages - Using Sliding Window
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.Arrays;

public class KRadiusSubarrayAverages_2 {
    public static void main(String[] args) {
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        long windowSum = 0;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if (n < windowSize) {
            return result;
        }
        for (int i = 0; i < n; ++i) {
            windowSum += nums[i]; // Add nums[i] to the window sum
            if (i - windowSize >= 0) {
                windowSum -= nums[i - windowSize]; // Remove nums[i - windowSize] from the window sum
            }
            if (i >= windowSize - 1) {
                result[i - k] = (int) (windowSum / windowSize); // Calculate and store the average in the result
            }
        }
        return result;
    }
}
