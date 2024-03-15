//Leetcode - Not accepted as TLE
//238. Product of Array Except Self - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        return ans;
    }
}
