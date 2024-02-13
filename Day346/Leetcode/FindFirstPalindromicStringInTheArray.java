//Leetcode
//2108. Find First Palindromic String in the Array - 2 pointer
//Time complexity: O(N.M) where N is the number of words in the input array and M is the maximum length of a word.
//Space complexity: O(1)

package Leetcode;

public class FindFirstPalindromicStringInTheArray {

    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (check(word)) {
                return word;
            }
        }
        return "";
    }

    static boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
