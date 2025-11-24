//Leetcode
//1018. Binary Prefix Divisible By 5
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        System.out.println(prefixesDivBy5(nums));
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int remainder = 0;
        for (int bit : nums) {
            if (bit == 1) {
                remainder = (remainder * 2 + 1) % 5;
            }
            if (bit == 0) {
                remainder = (remainder * 2) % 5;
            }
            if (remainder % 5 == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
