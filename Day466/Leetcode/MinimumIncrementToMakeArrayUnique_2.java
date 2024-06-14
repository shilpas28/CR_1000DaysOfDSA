//Leetcode
//945. Minimum Increment to Make Array Unique - Sorting
//Time complexity: O(NlogK) using TreeMap 
//Space complexity: O(K) for in-space sort

import java.util.TreeMap;

public class MinimumIncrementToMakeArrayUnique_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] nums) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int a : nums)
            count.put(a, count.getOrDefault(a, 0) + 1);
        int res = 0, need = 0;
        for (int x : count.keySet()) {
            int v = count.get(x);
            res += v * Math.max(need - x, 0) + v * (v - 1) / 2;
            need = Math.max(need, x) + v;
        }
        return res;
    }
}
