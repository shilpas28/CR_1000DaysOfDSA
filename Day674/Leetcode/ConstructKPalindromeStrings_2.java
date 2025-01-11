//Leetcode
//1400. Construct K Palindrome Strings - Bitmasking
//Time complexity: O(N) to iterate through the string and count set bits.
//Space complexity: O(1) due to constant space used for the bitmask.

package Leetcode;

public class ConstructKPalindromeStrings_2 {

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;

        int bitmask = 0;
        for (char c : s.toCharArray()) {
            bitmask ^= (1 << (c - 'a'));
        }

        int oddCount = Integer.bitCount(bitmask);
        return oddCount <= k;
    }
}
