//Leetcode
//1846. Maximum Element After Decreasing and Rearranging
//Time complexity: O(NlogN) - NlogN  for sorting
//Space complexity: O(1) - Constant Extra space required

package Leetcode;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 2, 1 };
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > res) {
                ++res;
            }
        }
        return res;
    }
}
