//Leetcode
//976. Largest Perimeter Triangle
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 2 };
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--)
            if (nums[i - 1] + nums[i - 2] > nums[i])
                return nums[i] + nums[i - 1] + nums[i - 2];
        return 0;
    }
}
