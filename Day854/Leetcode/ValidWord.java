//Leetcode
//3136. Valid Word
//Time complexity: O(N)
//Space complexity: O(1) 

public class ValidWord {

    public static void main(String[] args) {
        String word = "234Adas";
        System.out.println(isValid(word));
    }

    public static boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (ch == 'a' ||
                        ch == 'e' ||
                        ch == 'i' ||
                        ch == 'o' ||
                        ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }
}
