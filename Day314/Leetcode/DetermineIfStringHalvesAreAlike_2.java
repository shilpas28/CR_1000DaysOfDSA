//Leetcode
//1704. Determine if String Halves Are Alike - Same logic but lesser code lines 
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

import java.util.HashSet;

public class DetermineIfStringHalvesAreAlike_2 {

    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray())
            set.add(c);

        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i)))
                count++;
            if (set.contains(s.charAt(i + s.length() / 2)))
                count--;
        }

        return count == 0;
    }
}
