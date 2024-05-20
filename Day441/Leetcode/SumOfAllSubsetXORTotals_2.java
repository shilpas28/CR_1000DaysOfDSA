//Leetcode
//1863. Sum of All Subset XOR Totals
//Time complexity: O(2^N)
//Space complexity: O(N)

package Leetcode;

public class SumOfAllSubsetXORTotals_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        System.out.println(subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    static int dfs(int[] nums, int index, int currentXor) {
        // Base case: when all elements have been considered
        if (index == nums.length) {
            return currentXor;
        }
        // Include nums[index] in the subset
        int include = dfs(nums, index + 1, currentXor ^ nums[index]);
        // Exclude nums[index] from the subset
        int exclude = dfs(nums, index + 1, currentXor);
        return include + exclude;
    }
}
