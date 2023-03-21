//Leetcode - Optimal solution
//2348. Number of Zero-Filled Subarrays
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class NumberOfZeroFilledSubarrays_1 {
    
    public static void main(String[] args) {
        int nums[] = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else {
                res += (count) * (count + 1) / 2; // Formula for sum of n natural numbers
                count = 0;
            }
        }
        res += (count + 1) * count / 2;
        return res;
    }
}
