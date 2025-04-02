//Leetcode
//2873. Maximum Value of an Ordered Triplet I - Greedy 
//Time complexity: O(N^2)
//Space complexity: O(1)

public class MaximumValueOfAnOrderedTripletI_2 {

    public static void main(String[] args) {
        int[] nums = { 12, 6, 1, 2, 7 };
        System.out.println(maximumTripletValue(nums));
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int k = 2; k < n; k++) {
            int maxPrefix = nums[0];
            for (int j = 1; j < k; j++) {
                res = Math.max(res, (long) (maxPrefix - nums[j]) * nums[k]);
                maxPrefix = Math.max(maxPrefix, nums[j]);
            }
        }
        return res;
    }
}
