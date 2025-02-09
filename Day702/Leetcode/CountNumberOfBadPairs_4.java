//Leetcode
//2364. Count Number of Bad Pairs - HashMap
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class CountNumberOfBadPairs_4 {

    public static void main(String[] args) {
        int[] nums = { 4, 1, 3, 3 };
        System.out.println(countBadPairs(nums));
    }

    public static long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        long good = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            good += freq.getOrDefault(key, 0);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        return (long) nums.length * (nums.length - 1) / 2 - good;
    }
}
