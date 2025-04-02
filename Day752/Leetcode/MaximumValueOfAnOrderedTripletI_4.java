//Leetcode
//2873. Maximum Value of an Ordered Triplet I - Greedy 
//Time complexity: O(N)
//Space complexity: O(1)

public class MaximumValueOfAnOrderedTripletI_4 {

    public static void main(String[] args) {
        int[] nums = { 12, 6, 1, 2, 7 };
        System.out.println(maximumTripletValue(nums));
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }
}
