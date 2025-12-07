//GFG
//Number of distinct subsequences - Not accepted as TLE
//Time complexity: O(N^2)
//Space complexity: O(N) 

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctSubsequences {

    public static void main(String[] args) {
        String str = "gfg";
        System.out.println(distinctSubseq(str));
    }

    static int distinctSubseq(String str) {
        // code here
        int n = str.length();
        Set<String> ans = new HashSet<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                // check if the ith bit is set or not
                if ((num & (1 << i)) != 0) {
                    sub += str.charAt(i);
                }
            }
            ans.add(sub);
        }
        return ans.size();
    }
}
