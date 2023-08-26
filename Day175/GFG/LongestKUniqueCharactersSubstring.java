//GFG
//Longest K unique characters substring
//Time complexity: O(|S|)
//Space complexity: O(|S|)

package GFG;

import java.util.HashMap;

public class LongestKUniqueCharactersSubstring {

    public static void main(String[] args) {
        String S = "aabacbebebe";
        int K = 3;
        System.out.println(longestkSubstr(S, K));
    }

    public static int longestkSubstr(String s, int k) {
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
