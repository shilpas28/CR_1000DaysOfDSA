//Leetcode
//2206. Divide Array Into Equal Pairs - HashSet
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashSet;
import java.util.Set;

public class DivideArrayIntoEqualPairs_4 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 2, 2 };
        System.out.println(divideArray(nums));
    }

    public static boolean divideArray(int[] nums) {
        // Track unpaired numbers
        Set<Integer> unpaired = new HashSet<>();
        // Add numbers to set if unseen, remove if seen
        for (int num : nums) {
            if (unpaired.contains(num)) {
                unpaired.remove(num);
            } else {
                unpaired.add(num);
            }
        }
        // Return true if all numbers were paired
        return unpaired.isEmpty();
    }
}
