//Leetcode
//916. Word Subsets
//Time complexity: O(words1 + words2)
//Space complexity: O(words1.length + words2.length)

import java.util.ArrayList;
import java.util.List;

public class WordSubsets_2 {

    public static void main(String[] args) {
        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2 = { "e", "o" };
        System.out.println(wordSubsets(words1, words2));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bmax = count("");
        for (String b : words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList<>();
        search: for (String a : words1) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }
        return ans;
    }

    public static int[] count(String S) {
        int[] ans = new int[26];
        for (char c : S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
