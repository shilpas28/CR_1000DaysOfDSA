//Leetcode
//3254. Find the Power of K-Size Subarrays I - Two Pointers + Sliding Window
//Time complexity: O(n)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindThePowerOfKSizeSubarraysI_2 {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;
        System.out.println(Arrays.toString(resultsArray(nums, k)));
    }

    public static int[] resultsArray(int[] nums, int k) {
        // Skip if k is 1
        if (k == 1) {
            return nums;
        }

        int n = nums.length;
        List<Integer> resultList = new ArrayList<>();
        int left = 0;
        int right = 1;

        while (right < n) {
            // Check if current sequence is not consecutive
            boolean isNotConsecutive = nums[right] - nums[right - 1] != 1;

            if (isNotConsecutive) {
                // Mark invalid sequences
                while (left < right && left + k - 1 < n) {
                    resultList.add(-1);
                    left++;
                }
                left = right;
            }
            // Found valid k-length sequence
            else if (right - left == k - 1) {
                resultList.add(nums[right]);
                left++;
            }
            right++;
        }

        // Convert ArrayList to int array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
