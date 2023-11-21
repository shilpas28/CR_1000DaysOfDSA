//leetcode
//1814. Count Nice Pairs in an Array
//Time complexity: O(NlogN)
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class CountNicePairsInAnArray_2 {

    public static void main(String[] args) {
        int[] nums = { 42, 11, 1, 97 };
        System.out.println(countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        final int mod = 1000000007;

        int len = nums.length;
        for (int i = 0; i < len; i++)
            nums[i] = nums[i] - reverse(nums[i]);
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < len - 1; i++) {
            long cont = 1;
            while (i < len - 1 && nums[i] == nums[i + 1]) {
                cont++;
                i++;
            }
            res = (res % mod + (cont * (cont - 1)) / 2) % mod;
        }
        return (int) res % mod;
    }

    static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
