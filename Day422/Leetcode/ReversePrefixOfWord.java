//Leetcode
//2000. Reverse Prefix of Word
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

public class ReversePrefixOfWord {

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        char[] s1 = word.toCharArray();
        int end = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                end = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= 0; i--)
            sb.append(s1[i]);
        for (int i = end + 1; i < s1.length; i++)
            sb.append(s1[i]);

        return sb.toString();
    }
}
