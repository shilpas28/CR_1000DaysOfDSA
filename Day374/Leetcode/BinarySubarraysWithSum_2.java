//Leetcode
//930. Binary Subarrays With Sum - Using Hashmap
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int result = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            result += map.getOrDefault(prefixSum - goal, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
