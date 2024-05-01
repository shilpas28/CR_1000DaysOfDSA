//Leetcode
//2000. Reverse Prefix of Word - Using String in built methods
//Time complexity:
//Space complexity:

package Leetcode;

public class ReversePrefixOfWord_3 {

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int index = word.indexOf(ch);
        sb.append(word.substring(0, index + 1));
        sb.reverse();
        sb.append(word.substring(index + 1));
        return sb.toString();
    }
}
