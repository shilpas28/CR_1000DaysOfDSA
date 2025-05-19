//Leetcode
//3024. Type of Triangle - With Sort 
//Time complexity: O(1) - Since the length of nums is only 3, the time required for sorting can be ignored. 
//Space complexity: O(1)

import java.util.Arrays;

public class TypeOfTriangle {

    public static void main(String[] args) {
        int[] nums = { 3, 3, 3 };
        System.out.println(triangleType(nums));
        int[] nums1 = { 3, 4, 5 };
        System.out.println(triangleType(nums1));
    }

    public static String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        } else if (nums[0] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
