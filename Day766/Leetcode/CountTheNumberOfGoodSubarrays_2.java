//Leetcode
//2537. Count the Number of Good Subarrays - Sliding Window
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 3, 2, 2, 4 };
        int k = 2;
        System.out.println(countGood(nums, k));
    }

    public static long countGood(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        long cnt = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            while (k <= 0) {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                k += mpp.get(nums[left++]);
            }
            cnt += left;
        }
        return cnt;
    }
}
