//Leetcode
//368. Largest Divisible Subset
//Time complexity: O(n^2)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int[] parent = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0, maxind = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && count[i] < 1 + count[j]) {
                    count[i] = 1 + count[j];
                    parent[i] = j;
                    if (count[i] > max) {
                        max = count[i];
                        maxind = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            res.add(nums[maxind]);
            maxind = parent[maxind];
        }
        return res;
    }
}
