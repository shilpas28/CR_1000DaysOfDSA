//Leetcode
//645. Set Mismatch - Set + Sum 
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actual_sum = n * (n + 1) / 2;
        int array_sum = 0;
        int unique_sum = 0;
        Set<Integer> s = new HashSet<>();

        for (int a : nums) {
            array_sum += a;
        }

        for (int a : nums) {
            s.add(a);
        }

        for (int a : s) {
            unique_sum += a;
        }

        int missing = actual_sum - unique_sum;
        int duplicate = array_sum - unique_sum;

        return new int[] { duplicate, missing };
    }
}
