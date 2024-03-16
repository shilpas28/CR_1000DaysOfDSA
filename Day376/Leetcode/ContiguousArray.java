//Leetcode - Not accepted as TLE
//525. Contiguous Array - Brute Force
//Time complexity: O(N^2) as We consider every possible subarray by traversing over the complete array for every start point possible.
//Space complexity: O(1) as Only two variables zeroes and ones are required

package Leetcode;

public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0, ones = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }
}
