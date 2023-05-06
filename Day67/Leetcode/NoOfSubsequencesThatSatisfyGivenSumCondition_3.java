//Leetcode - same as 2 but just better structured and simpler code
//1498. Number of Subsequences That Satisfy the Given Sum Condition
//Time complexity: O(NlogN)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfSubsequencesThatSatisfyGivenSumCondition_3 {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 7 };
        int target = 9;
        System.out.println(numSubseq(nums, target));
    }

    public static int numSubseq(int[] nums, int target) {
        int res = 0, mod = 1000000007, l = 0, r = nums.length - 1;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= nums.length; ++i) {
            pre.add((pre.get(i - 1) << 1) % mod);
        }
        Arrays.sort(nums);
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pre.get(r - l++)) % mod;
            }
        }
        return res;
    }
}
