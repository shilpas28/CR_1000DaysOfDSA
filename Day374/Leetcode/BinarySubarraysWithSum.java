//Leetcode
//930. Binary Subarrays With Sum - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end < nums.length; ++end) {
                sum += nums[end];
                if (sum == goal)
                    ++res;
            }
        }
        return res;
    }
}
