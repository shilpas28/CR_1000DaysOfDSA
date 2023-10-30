//Leetcode
//1356. Sort Integers by The Number of 1 Bits
//Time complexity: 
//Space complexity: O(1)

package Leetcode;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits_2 {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    public static int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 10001;
        }

        return arr;
    }
}
