//GFG
//Word Break
//Time complexity: O(len(s)^2)
//Space complexity: O(len(s))

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak_2 {

    public static void main(String[] args) {

        int n = 6;
        // B = { "i", "like", "sam", "sung", "samsung", "mobile"}
        ArrayList<String> B = new ArrayList<>();
        B.add("i");
        B.add("like");
        B.add("sam");
        B.add("sung");
        B.add("Samsung");
        B.add("mobile");
        String A = "ilike";
        System.out.println(wordBreak(n, A, B));
    }

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
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
