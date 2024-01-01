//GFG
//Array Pair Sum Divisibility Problem
//Time complexity: O(n)
//Space complexity: O(n)

package GFG;

import java.util.HashSet;

public class ArrayPairSumDivisibilityProblem_3 {

    public static void main(String[] args) {
        int[] nums = { 9, 5, 7, 3 };
        int k = 6;
        System.out.println(canPair(nums, k));
    }

    public static boolean canPair(int[] nums, int k) {
        // Code here
        if (nums.length % 2 != 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int rem = (num % k + k) % k;
            int req = (k - rem) % k;
            if (set.contains(req))
                set.remove(req);
            else
                set.add(rem);
        }
        return set.isEmpty();
    }
}
