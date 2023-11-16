//Leetcode
//1980. Find Unique Binary String - Optimized approach: base2 to base10 
//Time complexity: O(2^N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString_2 {

    public static void main(String[] args) {
        String[] nums = { "01", "10" };
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet<>();
        // Binary string to base-10 integer
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        int n = nums.length;
        for (int i = 0; i < Math.pow(2, n); ++i) {
            if (!integers.contains(i)) {
                // Convert the found number back to a binary string of length n
                return String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            }
        }
        return "";
    }
}
