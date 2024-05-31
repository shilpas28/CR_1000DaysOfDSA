//Leetcode
//260. Single Number III
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII_2 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Build the frequency map
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // Find the elements that appear only once
        int[] result = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
