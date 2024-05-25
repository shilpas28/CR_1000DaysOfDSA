//Leetcode
//140. Word Break II
//Time complexity: O(2^N)
//Space complexity: O(2^N)

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreakII_2 {

    public static void main(String[] args) {
        String s = "catsanddog";
        // wordDict = ["cat","cats","and","sand","dog"]
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>(wordDict);
        return wordBreakHelper(s, 0, hs, hm);
    }

    static List<String> wordBreakHelper(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> hm) {
        if (hm.containsKey(start))
            return hm.get(start);

        List<String> validSubstr = new ArrayList<>();

        if (start == s.length())
            validSubstr.add("");
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (dict.contains(prefix)) {
                List<String> suffixes = wordBreakHelper(s, end, dict, hm);
                for (String suffix : suffixes) {
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }
        hm.put(start, validSubstr);
        return validSubstr;
    }
}
