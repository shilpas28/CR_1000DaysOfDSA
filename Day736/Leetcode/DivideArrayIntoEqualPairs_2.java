//Leetcode
//2206. Divide Array Into Equal Pairs - Map 
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 2, 2, 2 };
        System.out.println(divideArray(nums));
    }

    public static boolean divideArray(int[] nums) {
        // Count frequency of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        // Check if each number appears even number of times
        for (int num : frequency.keySet()) {
            if (frequency.get(num) % 2 != 0) {
                return false;
            }
        }
        // All numbers can be paired
        return true;
    }
}
