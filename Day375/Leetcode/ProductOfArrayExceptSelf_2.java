//Leetcode - Not accepted as we get divide by zero error
//238. Product of Array Except Self - Dividing the product of array with the number
//Time complexity: O(N)
//Space complexity: O(1) 

package Leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pro = 1;
        for (int i : nums) {
            pro *= i;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = pro / nums[i];
        }
        return ans;
    }
}
