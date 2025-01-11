//Leetcode
//1400. Construct K Palindrome Strings - Sorting and Grouping
//Time complexity: O(NlogN) for sorting the string.
//Space complexity: O(N) for storing the sorted characters.

package Leetcode;

import java.util.Arrays;

public class ConstructKPalindromeStrings {

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int oddCount = 0;

        for (int i = 0; i < chars.length;) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            if (count % 2 != 0)
                oddCount++;
        }
        return oddCount <= k;
    }
}
