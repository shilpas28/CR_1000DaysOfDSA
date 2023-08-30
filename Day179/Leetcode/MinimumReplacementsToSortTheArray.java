//Leetcode
//2366. Minimum Replacements to Sort the Array
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MinimumReplacementsToSortTheArray {

    public static void main(String[] args) {
        int nums[] = { 3, 9, 3 };
        System.out.println(minimumReplacement(nums));
    }

    public static long minimumReplacement(int[] nums) {
        long res = 0;
        int n = nums.length;
        long maxMinVal = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            long parts = (long) Math.ceil(nums[i] / (double) maxMinVal);
            // no. of steps is parts-1
            res += (parts - 1);
            // the new maximized minimum value in a part
            maxMinVal = nums[i] / parts;
        }
        return res;
    }
}
