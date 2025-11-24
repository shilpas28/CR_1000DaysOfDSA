//Leetcode
//1018. Binary Prefix Divisible By 5
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5_2 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        System.out.println(prefixesDivBy5(nums));
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int cur : nums) {
            num = ((num << 1) + cur) % 5;
            if (num == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
