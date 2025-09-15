//Leetcode
//1935. Maximum Number of Words You Can Type - HashSet with builtin functions
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfWordsYouCanType_2 {

    public static void main(String[] args) {
        String text = "hello world", brokenLetters = "ad";
        System.out.println(canBeTypedWords(text, brokenLetters));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {

        Set<Character> brokenKeys = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenKeys.add(c);
        }

        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean bad = false;
            for (char c : word.toCharArray()) {
                if (brokenKeys.contains(c)) {
                    bad = true;
                    break;
                }
            }
            if (!bad)
                count++;
        }

        return count;
    }
}
