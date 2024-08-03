//Leetcode
//1460. Make Two Arrays Equal by Reversing Subarrays - HashMap-based Frequency Counting
//Time complexity: O(N)
//Space complexity: O(k), where k is the number of unique elements

import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubarrays_3 {

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 4 };
        int[] arr = { 2, 4, 1, 3 };
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        // Create a HashMap to store frequency differences
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Iterate through both arrays simultaneously
        for (int i = 0; i < target.length; i++) {
            // Increment count for elements in target
            frequencyMap.merge(target[i], 1, Integer::sum);
            // Decrement count for elements in arr
            frequencyMap.merge(arr[i], -1, Integer::sum);
        }
        // Check if all frequency differences are zero
        return frequencyMap.values().stream().allMatch(count -> count == 0);
    }
}
