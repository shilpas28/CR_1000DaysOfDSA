//leetcode
//1814. Count Nice Pairs in an Array
//Time complexity: O(nloga) where a:length of number i.e 0<a<10
//Space complexity: O(n)

package Leetcode;

import java.util.HashMap;

public class CountNicePairsInAnArray {

    public static void main(String[] args) {
        int[] nums = { 42, 11, 1, 97 };
        System.out.println(countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        int mod = (int) Math.pow(10, 9) + 7;
        int count = 0;

        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long rev = reverse(nums[i]);

            long diff = nums[i] - rev;
            if (map.containsKey(diff)) {
                count = (count % mod + map.get(diff) % mod) % mod;
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }

    static long reverse(int num) {
        long rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
