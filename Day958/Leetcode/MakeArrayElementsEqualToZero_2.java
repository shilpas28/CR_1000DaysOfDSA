//Leetcode
//3354. Make Array Elements Equal to Zero - Without Extra Space (Optimal)
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;

public class MakeArrayElementsEqualToZero_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 0, 3 };
        System.out.println(countValidSelections(nums));
    }

    public static int countValidSelections(int[] nums) {
        int len = nums.length, count = 0, left = 0;
        int right = Arrays.stream(nums).sum();
        for (int i = 0; i < len; i++) {
            left += nums[i];
            right -= nums[i];
            if (nums[i] != 0)
                continue;
            if (left == right)
                count += 2;
            if (Math.abs(left - right) == 1)
                count++;
        }
        return count;
    }
}
