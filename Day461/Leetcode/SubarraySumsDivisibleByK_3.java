//Leetcode
//974. Subarray Sums Divisible by K - Array
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class SubarraySumsDivisibleByK_3 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int prefix = 0, res = 0;
        for (int a : nums) {
            prefix = (prefix + a % k + k) % k;
            res += count[prefix]++;
        }
        return res;
    }
}
