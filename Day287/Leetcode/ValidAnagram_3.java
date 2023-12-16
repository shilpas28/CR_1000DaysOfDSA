//Leetcode
//242. Valid Anagram - Hash Table (Using Array)
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ValidAnagram_3 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
