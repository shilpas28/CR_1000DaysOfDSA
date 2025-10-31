//Leetcode
//3289. The Two Sneaky Numbers of Digitville - Hash Table
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheTwoSneakyNumbersOfDigitville {

    public static void main(String[] args) {
        int[] nums = { 0, 3, 2, 1, 3, 2 };
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }

    public static int[] getSneakyNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            int c = count.getOrDefault(x, 0) + 1;
            count.put(x, c);
            if (c == 2) {
                res.add(x);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
