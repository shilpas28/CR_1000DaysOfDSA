//GFG
//Longest String Chain - Not accepted as TLE
//Time complexity: O(nlogn + n*m²)
//Space complexity: O(n*m)

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

    public static void main(String[] args) {
        String words[] = { "ba", "b", "a", "bca", "bda", "bdca" };
        System.out.println(longestStringChain(words));
    }

    public static int longestStringChain(String words[]) {
        // code here
        int n = words.length;
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (check(words[i], words[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        return maxi;
    }

    static boolean check(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;
        int f = 0;
        int s = 0;
        while (f < s1.length()) {
            if (s < s2.length() && s1.charAt(f) == s2.charAt(s)) {
                f++;
                s++;
            } else {
                f++;
            }
        }
        if (f == s1.length() && s == s2.length())
            return true;
        return false;
    }
}
