//Leetcode
//2874. Maximum Value of an Ordered Triplet II - Greedy + Prefix Suffix Array 
//Time complexity: O(N)
//Space complexity: O(N)

public class MaximumValueOfAnOrderedTripletII {

    public static void main(String[] args) {
        int[] nums = { 12, 6, 1, 2, 7 };
        System.out.println(maximumTripletValue(nums));
    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }
        return res;
    }
}
