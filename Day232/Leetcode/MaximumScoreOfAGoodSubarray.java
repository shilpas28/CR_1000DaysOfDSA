//Leetcode
//1793. Maximum Score of a Good Subarray
//Time complexity: O(N) - Each element of the array is visited at most twice: once when expanding to the left and once 
//when expanding to the right.
//Space complexity: O(1) - We only use a constant amount of extra space, irrespective of the input size.

package Leetcode;

public class MaximumScoreOfAGoodSubarray {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 7, 4, 5 };
        int k = 3;
        System.out.println(maximumScore(nums, k));
    }

    public static int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int min_val = nums[k];
        int max_score = min_val;

        while (left > 0 || right < nums.length - 1) {
            if (left == 0 || (right < nums.length - 1 && nums[right + 1] > nums[left - 1])) {
                right++;
            } else {
                left--;
            }
            min_val = Math.min(min_val, Math.min(nums[left], nums[right]));
            max_score = Math.max(max_score, min_val * (right - left + 1));
        }

        return max_score;
    }
}
