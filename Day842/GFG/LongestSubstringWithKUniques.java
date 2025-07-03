//GFG
//Longest Substring with K Uniques
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.HashMap;

public class LongestSubstringWithKUniques {

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }

    public static int longestKSubstr(String s, int k) {
        // code here
        int ans = -1;
        int i = 0, j = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (j < s.length()) {
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (hm.size() == k)
                ans = Math.max(ans, j - i + 1);
            while (hm.size() > k) {
                char x = s.charAt(i);
                hm.put(x, hm.get(x) - 1);
                if (hm.get(x) == 0) {
                    hm.remove(x);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
