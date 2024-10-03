//Leetcode
//1590. Make Sum Divisible by P
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        int p = 6;
        System.out.println(minSubarray(nums, p));
    }

    public static int minSubarray(int[] nums, int p) {
        int n = nums.length, res = n, need = 0, cur = 0;
        for (int a : nums)
            need = (need + a) % p;
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            last.put(cur, i);
            int want = (cur - need + p) % p;
            res = Math.min(res, i - last.getOrDefault(want, -n));
        }
        return res < n ? res : -1;
    }
}
