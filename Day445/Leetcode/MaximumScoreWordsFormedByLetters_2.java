//Leetcode
//1255. Maximum Score Words Formed by Letters - Recursion with backtracking
//Time complexity: O(2^n), for every word we call recursion up to 2 times.
//Space complexity: O(n), for recursive stack and keeping arrays

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumScoreWordsFormedByLetters_2 {

    public static void main(String[] args) {
        String[] words = { "dog", "cat", "dad", "good" };
        char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(maxScoreWords(words, letters, score));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int res = 0;

        int[] letters_count = new int[26];
        for (char letter : letters) {
            letters_count[letter - 'a']++;
        }

        Map<String, Integer> words_scores = new HashMap<>();
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                s += score[ch - 'a'];
            }
            words_scores.put(word, s);
        }

        res = recursion(0, 0, words, letters_count, words_scores, n);
        return res;
    }

    static int recursion(int cur_ind, int cur_score, String[] words, int[] letters_count,
            Map<String, Integer> words_scores, int n) {
        if (cur_ind == n) {
            return cur_score;
        }

        int res = cur_score;

        String word = words[cur_ind];
        int[] word_count = new int[26];
        boolean can_add_this_word = true;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            word_count[ch - 'a']++;
            if (word_count[ch - 'a'] > letters_count[ch - 'a']) {
                can_add_this_word = false;
                break;
            }
        }

        if (can_add_this_word) {
            for (int i = 0; i < 26; i++) {
                letters_count[i] -= word_count[i];
            }
            res = Math.max(res,
                    recursion(cur_ind + 1, cur_score + words_scores.get(word), words, letters_count, words_scores, n));
            for (int i = 0; i < 26; i++) {
                letters_count[i] += word_count[i];
            }
        }
        res = Math.max(res, recursion(cur_ind + 1, cur_score, words, letters_count, words_scores, n));
        return res;
    }
}
