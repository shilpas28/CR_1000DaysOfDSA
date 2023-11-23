//Leetcode
//1630. Arithmetic Subarrays - With Sorting
//Time complexity: O(m*n*logn)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public static void main(String[] args) {
        int[] nums = { 4, 6, 5, 9, 3, 7 };
        int[] l = { 0, 0, 2 };
        int[] r = { 2, 3, 5 };
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }
            ans.add(check(arr));
        }
        return ans;
    }

    static Boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
