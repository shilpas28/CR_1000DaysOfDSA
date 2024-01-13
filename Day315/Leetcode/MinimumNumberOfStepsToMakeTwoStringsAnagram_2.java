//Leetcode
//1347. Minimum Number of Steps to Make Two Strings Anagram
//Time complexity: O(n)
//Space complexity: O(1)

package Leetcode;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram_2 {

    public static void main(String[] args) {
        String s = "leetcode", t = "practice";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        int[] count = new int[26];
        int i = 0;

        // Storing the difference of frequencies of characters in t and s.
        while (i < s.length()) {
            count[t.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
            i++;
        }

        int ans = 0;
        i = 0;

        while (i < 26) {
            ans += Math.max(0, count[i]);
            i++;
        }

        return ans;
    }
}
