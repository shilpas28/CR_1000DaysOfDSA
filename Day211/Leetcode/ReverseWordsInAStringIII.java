//Leetcode
//557. Reverse Words in a String III
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            sb.append(reverseString(word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseString(String word) {
        StringBuilder str = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            str.append(word.charAt(i));
        }
        return str.toString();
    }
}
