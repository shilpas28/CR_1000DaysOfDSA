//Leetcode - not accepted as TLE
//456. 132 Pattern - Brute force method
//Time complexity: O(N^3)
//Space complexity: O(1)

package Leetcode;

public class OneThreeTwoPattern {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[j] > nums[k])
                        return true;
                }
            }
        }
        return false;
    }
}
