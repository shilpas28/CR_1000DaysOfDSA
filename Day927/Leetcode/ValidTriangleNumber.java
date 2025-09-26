//Leetcode
//611. Valid Triangle Number - Brute Force - Not accepted as TLE
//Time complexity: O(N^3)
//Space complexity: O(1)

package Leetcode;

public class ValidTriangleNumber {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 4 };
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] &&
                            nums[i] + nums[k] > nums[j] &&
                            nums[j] + nums[k] > nums[i]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
