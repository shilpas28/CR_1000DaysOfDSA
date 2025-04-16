//Leetcode
//2537. Count the Number of Good Subarrays - Brute Force - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 3, 2, 2, 4 };
        int k = 2;
        System.out.println(countGood(nums, k));
    }

    public static long countGood(int[] nums, int k) {
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> mpp = new HashMap<>();
            long pairs = 0;
            for (int j = i; j < nums.length; j++) {
                pairs += mpp.getOrDefault(nums[j], 0);
                mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
                if (pairs >= k)
                    cnt++;
            }
        }
        return cnt;
    }
}
