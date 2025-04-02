//Leetcode
//2873. Maximum Value of an Ordered Triplet I - Brute-force enumeration
//Time complexity: O(N^3)
//Space complexity: O(1)

public class MaximumValueOfAnOrderedTripletI {

    public static void main(String[] args) {
        int[] nums = { 12, 6, 1, 2, 7 };
        System.out.println(maximumTripletValue(nums));
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return res;
    }
}
