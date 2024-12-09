//Leetcode
//3152. Special Array II - Using Prefix Method 
//Time complexity: O(N) + O(Q)
//Space complexity: O(N)

import java.util.Arrays;

public class SpecialArrayII_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 1, 2, 6 };
        int[][] queries = { { 0, 4 } };
        System.out.println(Arrays.toString(isArraySpecial(nums, queries)));
    }

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] P = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            P[i] = P[i - 1] + (nums[i - 1] % 2 != nums[i] % 2 ? 1 : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int Count = P[queries[i][1]] - P[queries[i][0]];
            int Total = queries[i][1] - queries[i][0];
            if (Total == Count)
                ans[i] = true;
            else
                ans[i] = false;
        }
        return ans;
    }
}
