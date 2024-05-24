//Leetcode
//1255. Maximum Score Words Formed by Letters - Brute force with bit-mask
//Time complexity: O(2^n * n), we will iterate 2^n times to check every subset and every this subset has 
//up to n words so I think 2^n * n is fair assessment.
//Space complexity: O(n) where n is the length of the words but in fact this is too small so very close  
//to be O(1) (all other arrays have constant size so O(1) complexity)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumScoreWordsFormedByLetters {

    public static void main(String[] args) {
        String[] words = { "dog", "cat", "dad", "good" };
        char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(maxScoreWords(words, letters, score));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int res = 0;

        // count letters
        int[] letters_count = new int[26];
        for (char letter : letters) {
            int ind = letter - 'a';
            letters_count[ind] += 1;
        }

        // calculate words
        Map<String, Integer> words_scores = new HashMap<>();
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int ind = c - 'a';
                s += score[ind];
            }
            words_scores.put(word, s);
        }

        for (int mask = 0; mask < (1 << n); ++mask) { // There will be exactly 2^n different states
            int[] cur_count = new int[26];
            boolean can_create = true;
            int cur_score = 0;

            for (int word_ind = 0; word_ind < n; ++word_ind) {
                if ((mask & (1 << word_ind)) != 0) { // if in mask bit of this word is 1
                    String word = words[word_ind];
                    cur_score += words_scores.get(word);
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        int ind = c - 'a';
                        cur_count[ind]++;
                        if (cur_count[ind] > letters_count[ind]) {
                            can_create = false;
                            break;
                        }
                    }
                }
                if (!can_create) {
                    break;
                }
            }
            if (can_create && cur_score > res) {
                res = cur_score;
            }
        }
        return res;
    }
}
