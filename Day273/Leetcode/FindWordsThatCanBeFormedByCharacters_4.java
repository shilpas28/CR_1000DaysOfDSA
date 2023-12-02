//Leetcode
//1160. Find Words That Can Be Formed by Characters - Optimized Hash Map
//Time complexity: O(N * M), where N is the number of words and M is the average length of a word.
//Space complexity: O(K)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters_4 {

    public static void main(String[] args) {
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        for (String word : words) {
            if (canFormWord(word, new HashMap<>(charFreqMap))) {
                result += word.length();
            }
        }
        return result;
    }

    static boolean canFormWord(String word, Map<Character, Integer> charFreqMap) {
        for (char ch : word.toCharArray()) {
            if (!charFreqMap.containsKey(ch) || charFreqMap.get(ch) == 0) {
                return false;
            }
            charFreqMap.put(ch, charFreqMap.get(ch) - 1);
        }
        return true;
    }
}
