//GFG
//Better String
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class BetterString_2 {

    public static void main(String[] args) {
        String str1 = "gfg", str2 = "ggg";
        System.out.println(betterString(str1, str2));
    }

    public static String betterString(String str1, String str2) {
        // Code here
        // Count the number of substrings of each string
        int a = countSub(str1);
        int b = countSub(str2);
        // Return the string with more substrings
        if (a < b) {
            return str2;
        }
        return str1;
    }

    static int countSub(String str) {
        // map to store the last occurrence of characters
        Map<Character, Integer> map = new HashMap<>();

        int n = str.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {

            dp[i] = 2 * dp[i - 1];

            if (map.containsKey(str.charAt(i - 1))) {
                dp[i] = dp[i] - dp[map.get(str.charAt(i - 1))];
            }
            map.put(str.charAt(i - 1), (i - 1));
        }
        return dp[n];
    }
}
