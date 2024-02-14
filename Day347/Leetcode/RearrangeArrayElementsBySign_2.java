//Leetcode
//2149. Rearrange Array Elements by Sign - Optimized 
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class RearrangeArrayElementsBySign_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }
}
