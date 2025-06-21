//Leetcode
//3085. Minimum Deletions to Make String K-Special
//Time complexity: O(n+(C^2))
//Space complexity: O(C)

import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionsToMakeStringKSpecial {

    public static void main(String[] args) {
        String word = "aabcaba";
        int k = 0;
        System.out.println(minimumDeletions(word, k));
    }

    public static int minimumDeletions(String word, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        int res = word.length();
        for (int a : cnt.values()) {
            int deleted = 0;
            for (int b : cnt.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }
            res = Math.min(res, deleted);
        }
        return res;
    }
}
