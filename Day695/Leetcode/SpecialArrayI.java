//Leetcode
//3151. Special Array I - Modulo Comparison
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class SpecialArrayI {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4 };
        System.out.println(isArraySpecial(nums));
    }

    public static boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] % 2 == nums[i] % 2) {
                return false;
            }
        }
        return true;
    }
}
