//Leetcode
//1877. Minimize Maximum Pair Sum in Array
//Time complexity: O(NlogN) - The dominant factor in the time complexity is the sorting step, and the array sorting is done using 
//Arrays.sort(nums). The time complexity of the sorting operation is O(n log n), where 'n' is the length of the array. Therefore, 
//the overall time complexity of the code is O(n log n).
//Space complexity: O(1) - The space complexity is determined by the additional variables used in the code. In this case, the 
//only additional space used is for the minMaxPairSum, left, and right variables, which require constant space. Therefore, the 
//overall space complexity of the code is O(1) (constant space).

package Leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public static void main(String[] args) {
        int[] nums = { 3, 5, 2, 3 };
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(nums);
        // Step 2: Initialize pointers at the start and end of the sorted array
        int left = 0, right = nums.length - 1;
        // Step 3: Initialize a variable to store the minimum of the maximum pair sum
        int minMaxPairSum = Integer.MIN_VALUE;
        // Step 4: Iterate until the pointers meet
        while (left < right) {
            // Step 5: Calculate the current pair sum
            int currentPairSum = nums[left] + nums[right];
            // Step 6: Update the minimum of the maximum pair sum
            minMaxPairSum = Math.max(minMaxPairSum, currentPairSum);
            // Step 7: Move the pointers towards the center
            left++;
            right--;
        }
        // Step 8: Return the minimum of the maximum pair sum
        return minMaxPairSum;
    }
}
