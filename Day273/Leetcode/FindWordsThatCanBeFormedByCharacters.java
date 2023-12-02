//Leetcode
//1160. Find Words That Can Be Formed by Characters - Brute Force
//Time complexity: O(N * M * K), where N is the number of words, M is the average length of a word, and K is the length of chars.
//Space complexity: O(1)

package Leetcode;

public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        for (String word : words) {
            if (canFormWord(word, chars)) {
                result += word.length();
            }
        }
        return result;
    }

    static boolean canFormWord(String word, String chars) {
        int[] charCount = new int[26];

        for (char ch : chars.toCharArray()) {
            charCount[ch - 'a']++;
        }
        for (char ch : word.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                return false;
            }
            charCount[ch - 'a']--;
        }
        return true;
    }
}
