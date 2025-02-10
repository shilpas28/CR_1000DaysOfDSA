//Leetcode
//3174. Clear Digits - Brute Force
//Time complexity: O(N^2)
//Space complexity: O(1)

public class ClearDigits {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(clearDigits(s));
    }

    public static String clearDigits(String s) {
        int charIndex = 0;
        StringBuilder sb = new StringBuilder(s);
        // Until we reach the end of the string
        while (charIndex < sb.length()) {
            if (Character.isDigit(sb.charAt(charIndex))) {
                // Remove the digit from the string
                sb.deleteCharAt(charIndex);
                // If there is a character to the left of the digit, remove it
                if (charIndex > 0) {
                    sb.deleteCharAt(charIndex - 1);
                    // Adjust the index to account for the removed character
                    charIndex--;
                }
            } else {
                // Move to the next character if it's not a digit
                charIndex++;
            }
        }
        return sb.toString();
    }
}
