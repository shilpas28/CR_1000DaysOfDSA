//Leetcode - Problem similar to Best time to buy and sell stock 
//2016. Maximum Difference Between Increasing Elements 
//Time complexity: O(N)
//Space complexity: O(1) 
 
public class MaximumDifferenceBetweenIncreasingElements {

    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 4 };
        System.out.println(maximumDifference(nums));
    }

    public static int maximumDifference(int[] nums) {
        int ans = -1;
        int mini = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mini = Math.min(mini, nums[i]);
            if (nums[i] > mini) 
                ans = Math.max(ans, nums[i] - mini);
        }
        return ans;
    }
}
