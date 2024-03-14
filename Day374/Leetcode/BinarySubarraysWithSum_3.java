//Leetcode
//930. Binary Subarrays With Sum - Using Prefix Sum
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class BinarySubarraysWithSum_3 {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    static int atMost(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int count = 0, i = 0, j = 0, sum = 0;
        while (i < nums.length) {
            sum += nums[i];
            while (j < nums.length && sum > goal) {
                sum -= nums[j];
                j++;
            }
            count += i - j + 1;
            i++;
        }
        return count;
    }
}
