//GFG - not accepted as TLE
//Number of distinct subsequences - using Bit manipulation
//Time complexity:  O(2^n * n) - O(2^n) for the outer for loop and O(n) for the inner for loop.
//Space complexity: O(1)

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctSubsequences {

    public static void main(String[] args) {
        String s = "gfg";
        System.out.println(distinctSubsequences(s));
    }

    static int distinctSubsequences(String S) {
        // code here
        int n = S.length();
        Set<String> ans = new HashSet<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                // check if the ith bit is set or not
                if ((num & (1 << i)) != 0) {
                    sub += S.charAt(i);
                }
            }
            ans.add(sub);
        }
        return ans.size();
    }
}
