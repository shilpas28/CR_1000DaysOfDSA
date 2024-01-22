//Leetcode
//645. Set Mismatch - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                missing = i;
            }
        }
        return new int[] { dup, missing };
    }
}
