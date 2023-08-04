//Leetcode - Not accepted by Leetcode as TLE
//139. Word Break - Recursion
//Time complexity:
//Space complexity:

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                return true;
            }
        }
        return false;
    }
}
