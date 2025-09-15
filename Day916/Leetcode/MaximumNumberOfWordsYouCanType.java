//Leetcode
//1935. Maximum Number of Words You Can Type - HashSet
//Time complexity: O(N)
//Space complexity: O(N) 

package Leetcode;

import java.util.HashSet;

public class MaximumNumberOfWordsYouCanType {

    public static void main(String[] args) {
        String text = "hello world", brokenLetters = "ad";
        System.out.println(canBeTypedWords(text, brokenLetters));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        
        HashSet<Character> brokenKeys = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenKeys.add(c);
        }

        int count = 0;
        boolean brokenWord = false;
        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length() && brokenKeys.contains(text.charAt(i)))
                brokenWord = true;
            if (i == text.length() || text.charAt(i) == ' ') {
                if (!brokenWord)
                    count++;
                brokenWord = false;
            }
        }
        return count;
    }
}
