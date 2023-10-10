//Leetcode
//2009. Minimum Number of Operations to Make Array Continuous
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeArrayContinuous {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 6 };
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count = Integer.MAX_VALUE, j = 1, dup = 0;
        int[] dupArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] <= nums[i] + nums.length - 1) {
                if (nums[j] == nums[j - 1])
                    ++dup;
                dupArr[j] = dup;
                j++;
            }
            count = Math.min(count, i + (nums.length - j) + dup - dupArr[i]);
        }
        return count;
    }
}
