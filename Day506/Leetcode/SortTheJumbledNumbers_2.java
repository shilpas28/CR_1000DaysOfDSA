//Leetcode
//2191. Sort the Jumbled Numbers - Directly Translate Integer
//Time complexity: O(n * log n), since we still use built-in sort functions and change every number digit by digit (though I believe that 
//due to the inner implementation (integers are something computer understands in bits) work with integers are way faster)
//Space complexity: O(n), since we still use number_mapping hashmap

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortTheJumbledNumbers_2 {

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
        if (num == 0) {
            return mapping[0];
        }
        int res = 0;
        int curMult = 1;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            res += mapping[digit] * curMult;
            curMult *= 10;
        }
        return res;
    }
}
