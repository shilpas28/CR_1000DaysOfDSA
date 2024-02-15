//Leetcode
//2971. Find Polygon With the Largest Perimeter - With Forward Iteration
//Time complexity: O(nlogn)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter_2 {

    public static void main(String[] args) {
        int[] nums = { 5, 5, 5 };
        System.out.println(largestPerimeter(nums));
    }

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < sum) {
                ans = nums[i] + sum;
            }
            sum += nums[i];
        }
        return ans;
    }
}
