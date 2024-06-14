//Leetcode
//945. Minimum Increment to Make Array Unique - Sorting 
//Time complexity: O(NlogN) for sorting
//Space complexity: O(1) for in-space sort

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0, need = 0;
        for (int a : nums) {
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return res;
    }
}
