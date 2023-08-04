//Leetcode - Not accepted by Leetcode. Error in a test case.
//139. Word Break - Top Down DP
//Time complexity:
//Space complexity:

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_2 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    static Map<String, Boolean> map = new HashMap();

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        if (map.containsKey(s))
            return map.get(s);
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
