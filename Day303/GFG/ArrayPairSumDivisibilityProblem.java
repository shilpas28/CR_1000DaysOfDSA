//GFG
//Array Pair Sum Divisibility Problem
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairSumDivisibilityProblem {

    public static void main(String[] args) {
        int[] nums = { 9, 5, 7, 3 };
        int k = 6;
        System.out.println(canPair(nums, k));
    }

    public static boolean canPair(int[] nums, int k) {
        // Code here
        if (nums.length % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            int y = i % k;
            if (mp.getOrDefault((k - y) % k, 0) != 0) {
                mp.put((k - y) % k, mp.get((k - y) % k) - 1);
            } else {
                mp.put(y, mp.getOrDefault(y, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
