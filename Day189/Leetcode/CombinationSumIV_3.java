//Leetcode 
//377. Combination Sum IV - DP solution(Tabulation/Bottom up)
//Time complexity: O(N^2)
//Space complexity: O(N) only for the DP array. No recursive stack space as no recursion.

package Leetcode;

public class CombinationSumIV_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}
