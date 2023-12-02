//Leetcode
//1160. Find Words That Can Be Formed by Characters - Hash Map
//Time complexity: O(N * (M + K)), where N is the number of words, M is the average length of a word, and K is the length of chars.
//Space complexity: O(K)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters_2 {

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
            if (canFormWord(word, charFreqMap)) {
                result += word.length();
            }
        }
        return result;
    }

    static boolean canFormWord(String word, Map<Character, Integer> charFreqMap) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (!charFreqMap.containsKey(ch) || charFreqMap.get(ch) < count) {
                return false;
            }
        }
        return true;
    }
}
