//Leetcode
//3289. The Two Sneaky Numbers of Digitville - Bitwise Operations
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.Arrays;

public class TheTwoSneakyNumbersOfDigitville_2 {

    public static void main(String[] args) {
        int[] nums = { 0, 3, 2, 1, 3, 2 };
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }

    public static int[] getSneakyNumbers(int[] nums) {

        int n = nums.length - 2;
        int y = 0;
        for (int x : nums) {
            y ^= x;
        }
        for (int i = 0; i < n; i++) {
            y ^= i;
        }

        int lowBit = y & -y;
        int x1 = 0;
        int x2 = 0;

        for (int x : nums) {
            if ((x & lowBit) != 0) {
                x1 ^= x;
            } else {
                x2 ^= x;
            }
        }

        for (int i = 0; i < n; i++) {
            if ((i & lowBit) != 0) {
                x1 ^= i;
            } else {
                x2 ^= i;
            }
        }
        return new int[] { x1, x2 };
    }
}
