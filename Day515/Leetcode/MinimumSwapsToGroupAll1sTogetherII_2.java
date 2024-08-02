//Leetcode
//2134. Minimum Swaps to Group All 1's Together II
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumSwapsToGroupAll1sTogetherII_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 0, 1, 1, 0 };
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        // Count total number of 1's
        for (int num : nums) {
            totalOnes += num;
        }
        // Edge cases
        if (totalOnes == 0 || totalOnes == n)
            return 0;
        int onesInWindow = 0;
        // Count 1's in the first window of size totalOnes
        for (int i = 0; i < totalOnes; i++) {
            onesInWindow += nums[i];
        }
        int maxOnesInWindow = onesInWindow;
        // Slide the window and update max
        for (int i = 0; i < n; i++) {
            onesInWindow = onesInWindow - nums[i] + nums[(i + totalOnes) % n];
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInWindow);
        }
        return totalOnes - maxOnesInWindow;
    }
}
