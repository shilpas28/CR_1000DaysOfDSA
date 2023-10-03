//Leetcode - Better method using Hashmaps
//1512. Number of Good Pairs
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                result += map.get(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
