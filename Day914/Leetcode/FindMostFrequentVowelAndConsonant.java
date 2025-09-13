//Leetcode
//3541. Find Most Frequent Vowel and Consonant - Set
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMostFrequentVowelAndConsonant {

    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
    }

    public static int maxFreqSum(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] freq = new int[26];

        int maxVowel = 0, maxConsonant = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;

            if (vowels.contains(c)) {
                maxVowel = Math.max(maxVowel, freq[idx]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[idx]);
            }
        }

        return maxVowel + maxConsonant;
    }
}
