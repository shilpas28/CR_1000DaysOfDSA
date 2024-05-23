//Leetcode
//2597. The Number of Beautiful Subsets - Recursion + Backtracking
//Time complexity: O(2^n)
//Space complexity: O(n) 

import java.util.HashMap;

public class TheNumberOfBeautifulSubsets {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6 };
        int k = 2;
        System.out.println(beautifulSubsets(nums, k));
    }

    static HashMap<Integer, Integer> freq;

    public static int beautifulSubsets(int[] nums, int k) {
        freq = new HashMap<Integer, Integer>();
        return beautifulSubsets(nums, k, 0) - 1; // -1 for empty subset
    }

    static int beautifulSubsets(int[] nums, int k, int i) {
        if (i == nums.length) { // base case
            return 1;
        }
        int result = beautifulSubsets(nums, k, i + 1); // nums[i] not taken
        if (!freq.containsKey(nums[i] - k) && !freq.containsKey(nums[i] + k)) { // check if we can take nums[i]
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            result += beautifulSubsets(nums, k, i + 1); // nums[i] taken
            freq.put(nums[i], freq.get(nums[i]) - 1);
            if (freq.get(nums[i]) == 0) {
                freq.remove(nums[i]);
            }
        }
        return result;
    }
}
