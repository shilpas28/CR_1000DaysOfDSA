//Leetcode
//2000. Reverse Prefix of Word - Using stack to reverse
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.Stack;

public class ReversePrefixOfWord_2 {

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        boolean found = false;
        int i = 0;
        while (i < word.length() && !found) {
            stack.add(word.charAt(i));
            found = word.charAt(i) == ch;
            i++;
        }
        if (!found)
            return word;

        StringBuilder res = new StringBuilder();
        while (stack.size() > 0)
            res.append(stack.pop());
        while (i < word.length())
            res.append(word.charAt(i++));

        return res.toString();
    }
}
