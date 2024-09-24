//Leetcode
//3043. Find the Length of the Longest Common Prefix
//Time complexity: O(m x d + n x d) = O(m + n)
//Space complexity: O(n x d) = O(n)

package Leetcode;

import java.util.HashMap;

public class FindTheLengthOfTheLongestCommonPrefix {

    public static void main(String[] args) {
        int[] arr1 = { 1, 10, 100 };
        int[] arr2 = { 1000 };
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        // Store all prefixes of the first array
        for (int val : arr1) {
            int num = val;
            while (num > 0) {
                prefix.put(num, prefix.getOrDefault(num, 0) + 1);
                num /= 10;
            }
        }
        // Variable to track the maximum length
        int mx = Integer.MIN_VALUE;
        // Instead of creating another map, check the prefix at the moment
        for (int val : arr2) {
            int num = val;
            // Count the number of digits in num
            int len = (int) Math.log10(num) + 1;
            // Generate all prefixes again
            while (num > 0) {
                // If prefix found, break
                if (prefix.containsKey(num)) {
                    break;
                }
                num /= 10;
                // Decrease digit count as we decrease prefix
                len--;
            }
            mx = Math.max(mx, len);
        }
        return mx;
    }
}
