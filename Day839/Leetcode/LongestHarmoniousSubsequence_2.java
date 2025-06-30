//Leetcode
//594. Longest Harmonious Subsequence - HashMap
//Time complexity: O(n)
//Space complexity: O(n) 

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Step 1: Count frequencies of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        // Step 2: Check all possible (num, num+1) pairs
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(num + 1)) {
                int currentLength = frequencyMap.get(num) + frequencyMap.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
