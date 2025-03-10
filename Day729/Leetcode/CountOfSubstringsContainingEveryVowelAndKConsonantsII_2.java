//Leetcode
//3306. Count of Substrings Containing Every Vowel and K Consonants II - Sliding Window (Relaxed Constraints)
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.HashMap;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII_2 {

    public static void main(String[] args) {
        String word = "aeioqq";
        int k = 1;
        System.out.println(countOfSubstrings(word, k));
    }

    public static long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    static long atLeastK(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;
        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);
            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                        newLetter,
                        vowelCount.getOrDefault(newLetter, 0) + 1);
            } else {
                consonantCount++;
            }
            // shrink window while we have a valid substring
            while (vowelCount.size() == 5 && consonantCount >= k) {
                numValidSubstrings += word.length() - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                            startLetter,
                            vowelCount.get(startLetter) - 1);
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }
            end++;
        }
        return numValidSubstrings;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
