//GFG
//Longest substring with distinct characters - Using HashMap as GFG is not accepting HashSet 
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.HashMap;

public class LongestSubstringWithDistinctCharacters_4 {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }

    public static int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        HashMap<Integer, Integer> set = new HashMap<>();
        int dp[] = new int[n];
        char str[] = s.toCharArray();

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (set.containsKey((int) str[i])) {
                set.remove((int) str[j]);
                j++;
            }
            set.put((int) str[i], 0);

            dp[i] = Math.max((i - j + 1), i > 0 ? dp[i - 1] : 1);
        }
        return dp[n - 1];
    }
}
