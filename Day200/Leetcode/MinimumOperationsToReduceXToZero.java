//Leetcode
//1658. Minimum Operations to Reduce X to Zero
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length;
        for (int i : nums)
            sum += i;
        int target = sum - x;
        int currSum = 0, maxLen = 0;
        int i = 0; // starting index of subarray
        boolean found = false;
        for (int j = 0; j < n; j++) {
            currSum += nums[j];

            // shrinking our window
            while (i <= j && currSum > target) {
                currSum -= nums[i];
                i += 1;
            }
            if (currSum == target) {
                found = true;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return found ? n - maxLen : -1;
    }
}
