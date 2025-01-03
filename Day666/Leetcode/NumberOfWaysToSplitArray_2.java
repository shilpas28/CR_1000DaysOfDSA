//Leetcode
//2270. Number of Ways to Split Array - Optimized Prefix and Suffix Sums
//Time complexity: O(N)
//Space complexity: O(1) 

public class NumberOfWaysToSplitArray_2 {

    public static void main(String[] args) {
        int nums[] = { 10, 4, -8, 7 };
        System.out.println(waysToSplitArray(nums));
    }

    public static int waysToSplitArray(int[] nums) {
        // Keep track of sum of elements on left and right sides
        long leftSum = 0, rightSum = 0;
        // Initially all elements are on right side
        for (int num : nums) {
            rightSum += num;
        }

        int count = 0;
        // Try each possible split position
        for (int i = 0; i < nums.length - 1; i++) {
            // Move current element from right to left side
            leftSum += nums[i];
            rightSum -= nums[i];
            // Check if this creates a valid split
            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;
    }
}
