//Leetcode
//2108. Find First Palindromic String in the Array - Reverse
//Time complexity: O(N.M) where N is the number of words in the input array and M is the maximum length of a word.
//Space complexity: O(1)

package Leetcode;

public class FindFirstPalindromicStringInTheArray_2 {

    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println(firstPalindrome(words));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            if (word.equals(sb.reverse().toString())) {
                return word;
            }
        }
        return "";
    }
}
