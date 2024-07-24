//Leetcode
//2191. Sort the Jumbled Numbers - Data Type Conversion
//Time complexity: O(n * log n), since we use built-in sort functions (usually n * log n) and also perform many strings/array manipulations
//Space complexity: O(n), since sorts algorithms usually take extra space (O(n) of O(log n) depending on language) and we use 
//number_mapping with size n -> O(n) anyway

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortTheJumbledNumbers {

    public static void main(String[] args) {
        int[] mapping = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
        int[] nums = { 991, 338, 38 };
        int[] res = sortJumbled(mapping, nums);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {

        Map<Integer, Integer> numberMapping = new HashMap<>();
        for (int num : nums) {
            if (!numberMapping.containsKey(num)) {
                numberMapping.put(num, translateInteger(num, mapping));
            }
        }

        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsBoxed, (a, b) -> Integer.compare(numberMapping.get(a), numberMapping.get(b)));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }
        return nums;
    }

    static int translateInteger(int num, int[] mapping) {
        char[] digits = Integer.toString(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (char) ('0' + mapping[digits[i] - '0']);
        }
        return Integer.parseInt(new String(digits));
    }
}
