//Leetcode
//1935. Maximum Number of Words You Can Type - 32-bit Bitmask
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class MaximumNumberOfWordsYouCanType_3 {

    public static void main(String[] args) {
        String text = "hello world", brokenLetters = "ad";
        System.out.println(canBeTypedWords(text, brokenLetters));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        
        int mask = 0;
        for (int i = 0; i < brokenLetters.length(); i++) {
            mask |= 1 << (brokenLetters.charAt(i) - 97);
        }

        int count = 0;
        boolean brokenWord = false;
        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length() && (mask & (1 << (text.charAt(i) - 97))) != 0)
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
