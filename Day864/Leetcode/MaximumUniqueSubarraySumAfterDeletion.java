//Leetcode
//3487. Maximum Unique Subarray Sum After Deletion
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int[] nums) {
        // Check if all elements are negative
        boolean allNegative = true;
        int maxValue = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= 0) {
                allNegative = false;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        if (allNegative)
            return maxValue;
        // Use a set to remove duplicates
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            unique.add(n);
        }
        // Sum all positive numbers from the set
        int sum = 0;
        for (int val : unique) {
            if (val > 0) {
                sum += val;
            }
        }
        return sum;
    }
}
