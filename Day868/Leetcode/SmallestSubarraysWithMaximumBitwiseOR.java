//Leetcode
//2411. Smallest Subarrays With Maximum Bitwise OR
//Time complexity: O(n*32) = O(n)
//Space complexity: O(n+32) = O(n)

import java.util.Arrays;

public class SmallestSubarraysWithMaximumBitwiseOR {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 1, 3 };
        System.out.println(Arrays.toString(smallestSubarrays(nums)));
    }

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] nearest = new int[32];
        Arrays.fill(nearest, -1);
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    nearest[j] = i;
                }
            }

            int lastSetBit = i;
            for (int j = 0; j < 32; j++) {
                if (nearest[j] != -1) {
                    lastSetBit = Math.max(lastSetBit, nearest[j]);
                }
            }

            ans[i] = lastSetBit - i + 1;
        }
        return ans;
    }
}
