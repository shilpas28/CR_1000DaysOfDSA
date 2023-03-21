//Leetcode - doesnt accept as TLE (Brute force)
//2348. Number of Zero-Filled Subarrays
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
        int nums[] = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    ans++;
                else
                    break;
            }
        }
        return ans;
    }
}
