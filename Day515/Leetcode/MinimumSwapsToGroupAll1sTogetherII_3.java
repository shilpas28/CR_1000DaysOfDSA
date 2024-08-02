//Leetcode
//2134. Minimum Swaps to Group All 1's Together II
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumSwapsToGroupAll1sTogetherII_3 {

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
        int currentOnes = 0;
        // Count 1's in the first window of size totalOnes
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }
        int maxOnes = currentOnes;
        // Use two pointers to slide the window
        for (int i = 0; i < n; i++) {
            currentOnes -= nums[i];
            currentOnes += nums[(i + totalOnes) % n];
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return totalOnes - maxOnes;
    }
}
