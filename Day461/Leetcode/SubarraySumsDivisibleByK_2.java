//Leetcode
//974. Subarray Sums Divisible by K - HashMap
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK_2 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, res = 0;
        for (int a : nums) {
            prefix = (prefix + a % k + k) % k;
            res += count.getOrDefault(prefix, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}
