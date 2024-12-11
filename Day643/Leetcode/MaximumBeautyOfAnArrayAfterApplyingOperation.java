//Leetcode
//2779. Maximum Beauty of an Array After Applying Operation
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {

    public static void main(String[] args) {
        int nums[] = { 4, 6, 1, 2 };
        int k = 2;
        System.out.println(maximumBeauty(nums, k));
    }

    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j, n = nums.length;
        for (j = 0; j < n; ++j)
            if (nums[j] - nums[i] > k * 2)
                i++;
        return j - i;
    }
}
