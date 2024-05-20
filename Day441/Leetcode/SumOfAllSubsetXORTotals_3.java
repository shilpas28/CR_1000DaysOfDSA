//Leetcode
//1863. Sum of All Subset XOR Totals
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

public class SumOfAllSubsetXORTotals_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        System.out.println(subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        int sumTotal = 0;
        for (int num : nums) {
            sumTotal |= num;
        }
        return sumTotal << (nums.length - 1);
    }
}
