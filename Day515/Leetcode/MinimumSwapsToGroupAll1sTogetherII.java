//Leetcode
//2134. Minimum Swaps to Group All 1's Together II
//Time complexity: O(N)
//Space complexity: O(N) 

public class MinimumSwapsToGroupAll1sTogetherII {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 0, 1, 1, 0 };
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        // Count total number of 1's and create a doubled array
        int[] doubledNums = new int[2 * n];
        for (int i = 0; i < n; i++) {
            totalOnes += nums[i];
            doubledNums[i] = doubledNums[i + n] = nums[i];
        }
        // Edge cases
        if (totalOnes == 0 || totalOnes == n)
            return 0;
        // Create cumulative sum array
        int[] cumulativeSum = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            cumulativeSum[i + 1] = cumulativeSum[i] + doubledNums[i];
        }
        int maxOnesInWindow = 0;
        // Check all possible windows of size totalOnes
        for (int i = 0; i <= n; i++) {
            int onesInWindow = cumulativeSum[i + totalOnes] - cumulativeSum[i];
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInWindow);
        }
        return totalOnes - maxOnesInWindow;
    }
}
