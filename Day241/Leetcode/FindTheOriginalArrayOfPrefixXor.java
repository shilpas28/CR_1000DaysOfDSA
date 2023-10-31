//Leetcode
//2433. Find The Original Array of Prefix Xor
//Time complexity: O(N) - We iterate through the pref array once, and each operation is constant time.
//Space complexity: O(N) - We use additional space to store the result array.

package Leetcode;

import java.util.Arrays;

public class FindTheOriginalArrayOfPrefixXor {

    public static void main(String[] args) {
        int[] pref = { 5, 2, 0, 3, 1 };
        System.out.println(Arrays.toString(findArray(pref)));
    }

    public static int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            result[i] = pref[i] ^ pref[i - 1];
        }
        return result;
    }
}
