//Leetcode
//1002. Find Common Characters
//Time complexity: O(N x L)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] words = { "bella", "label", "roller" };
        System.out.println(commonChars(words));
    }

    public static List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        return result;
    }
}
