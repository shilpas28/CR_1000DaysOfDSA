//Leetcode
//1400. Construct K Palindrome Strings - Using a Counter
//Time complexity: O(N) for counting characters and calculating the number of odd frequencies.
//Space complexity: O(1) due to fixed space for the character count (max 26 letters for English alphabet).

package Leetcode;

import java.util.HashMap;

public class ConstructKPalindromeStrings_3 {

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int freq : charCount.values()) {
            if (freq % 2 != 0)
                oddCount++;
        }
        return oddCount <= k;
    }
}
