//Leetcode
//1498. Number of Subsequences That Satisfy the Given Sum Condition
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 7 };
        int target = 9;
        System.out.println(numSubseq(nums, target));
    }

    public static int numSubseq(int[] nums, int target) {
        int res = 0, mod = 1000000007;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= nums.length; ++i)
            pre.add((pre.get(i - 1) << 1) % mod);

        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target)
                --j;

            if (j >= i) {
                int pw = pre.get(j - i);
                res = (res + pw) % mod;
            }
        }
        return res;
    }
}
