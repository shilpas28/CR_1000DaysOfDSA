//Leetcode - Not accepted as TLE
//377. Combination Sum IV - Recursive solution
//Time complexity:
//Space complexity: 

package Leetcode;

public class CombinationSumIV {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }
}
