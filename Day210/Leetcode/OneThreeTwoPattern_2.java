//Leetcode - not accepted as TLE
//456. 132 Pattern - Better method
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class OneThreeTwoPattern_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        int mine = nums[0];
        for (int j = 0; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] > mine && nums[j] > nums[k])
                    return true;
                mine = Math.min(mine, nums[j]);
            }
        }
        return false;
    }
}
