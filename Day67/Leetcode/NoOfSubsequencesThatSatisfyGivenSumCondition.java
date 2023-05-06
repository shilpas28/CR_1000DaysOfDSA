//Leetcode
//1498. Number of Subsequences That Satisfy the Given Sum Condition
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;

public class NoOfSubsequencesThatSatisfyGivenSumCondition {

    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 7 };
        int target = 9;
        System.out.println(numSubseq(nums, target));
    }

    public static int numSubseq(int[] nums, int target) {
        int res = 0, mod = 1000000007;
        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target)
                --j;

            if (j >= i) {
                int pw = (int) power(2, j - i, mod);
                res = (res + pw) % mod;
            }
        }
        return res;
    }

    static long power(long a, long n, long p) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * a) % p;
                n--;
            } else {
                a = (a * a) % p;
                n = n / 2;
            }
        }
        return res;
    }
}
