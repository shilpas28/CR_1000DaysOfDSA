//Leetcode
//2559. Count Vowel Strings in Ranges
//Time complexity: O(n+m) where n is length of words and m is length of queries
//Space complexity: O(n) 

import java.util.Arrays;

public class CountVowelStringsInRanges {

    public static void main(String[] args) {
        String words[] = { "aba", "bcb", "ece", "aa", "e" };
        int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String word = words[i - 1];
            if (word.length() >= 1 && vowel(word.charAt(0)) && vowel(word.charAt(word.length() - 1))) {
                preSum[i] = preSum[i - 1] + 1;
            } else {
                preSum[i] = preSum[i - 1];
            }
        }
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            arr[i] = preSum[b + 1] - preSum[a];
        }
        return arr;
    }

    static boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
