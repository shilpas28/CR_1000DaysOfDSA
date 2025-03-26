//GFG
//Word Break - Not accepted as TLE
//Time complexity: O(len(s)^2)
//Space complexity: O(len(s))

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak_2 {

    public static void main(String[] args) {
        String s = "ilike";
        String dictionary[] = { "i", "like", "gfg" };
        System.out.println(wordBreak(s, dictionary));
    }

    public static int wordBreak(String s, String[] dictionary) {
        // code here
        Set<String> set = new HashSet<>();
        for (String str : dictionary)
            set.add(str);
        int[] dp = new int[1101];
        Arrays.fill(dp, -1);
        return help(0, s, set, dp);
    }

    static int help(int i, String A, Set<String> set, int[] dp) {
        if (i == A.length())
            return 1;
        if (dp[i] != -1)
            return dp[i];
        StringBuilder temp = new StringBuilder();
        for (int j = i; j < A.length(); ++j) {
            temp.append(A.charAt(j));
            if (set.contains(temp.toString())) {
                if (help(j + 1, A, set, dp) == 1) {
                    return dp[i] = 1;
                }
            }
        }
        return dp[i] = 0;
    }
}
