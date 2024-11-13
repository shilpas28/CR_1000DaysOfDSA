//Leetcode
//2563. Count the Number of Fair Pairs - Two Pointer Method
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class CountTheNumberOfFairPairs_2 {

    public static void main(String[] args) {
        int nums[] = { 0, 1, 7, 4, 4, 5 };
        int lower = 3, upper = 6;
        System.out.println(countFairPairs(nums, lower, upper));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper) - countLess(nums, lower - 1);
    }

    static long countLess(int[] nums, int val) {
        long res = 0;
        for (int i = 0, j = nums.length - 1; i < j; ++i) {
            while (i < j && nums[i] + nums[j] > val)
                --j;
            res += j - i;
        }
        return res;
    }
}
