//Leetcode
//1356. Sort Integers by The Number of 1 Bits
//Time complexity: O(n + n * logn + n) => O(n * logn)
//Space complexity: O(2n) => O(n)

package Leetcode;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    public static int[] sortByBits(int[] arr) {
        int n = arr.length;
        // store the element and its 1-bits count
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = Integer.bitCount(arr[i]);
            a[i][1] = arr[i];
        }
        // Sort in increasing order of number of 1 bits
        // if number of 1 bits is same,
        // sort in increasing order of the element itself
        Arrays.sort(a, (x, y) -> (x[0] == y[0]) ? (x[1] - y[1]) : (x[0] - y[0]));
        // put the sorted elements back to the given array
        for (int i = 0; i < n; i++) {
            arr[i] = a[i][1];
        }

        return arr; // return the array
    }
}
