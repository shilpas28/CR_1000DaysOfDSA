//GFG
//Boolean Parenthesization 
//Time complexity: O(N^3)
//Space complexity: O(N^2)

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesization_3 {

    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(countWays(s));
    }

    static int countWays(String s) {
        // code here
        int n = s.length();
        Map<String, Integer> dp = new HashMap<>();
        return countWaysUtil(s, 0, n - 1, true, dp);
    }

    static int countWaysUtil(String s, int i, int j, boolean isTrue, Map<String, Integer> dp) {
        if (i > j)
            return 0;
        if (i == j)
            return isTrue ? (s.charAt(i) == 'T' ? 1 : 0) : (s.charAt(i) == 'F' ? 1 : 0);
        String key = i + "," + j + "," + isTrue;
        if (dp.containsKey(key))
            return dp.get(key);

        int ways = 0;

        for (int k = i + 1; k < j; k += 2) {
            char op = s.charAt(k);

            int lt = countWaysUtil(s, i, k - 1, true, dp);
            int lf = countWaysUtil(s, i, k - 1, false, dp);
            int rt = countWaysUtil(s, k + 1, j, true, dp);
            int rf = countWaysUtil(s, k + 1, j, false, dp);

            if (op == '&') {
                ways += isTrue ? lt * rt : lt * rf + lf * rt + lf * rf;
            } else if (op == '|') {
                ways += isTrue ? lt * rt + lt * rf + lf * rt : lf * rf;
            } else if (op == '^') {
                ways += isTrue ? lt * rf + lf * rt : lt * rt + lf * rf;
            }
        }

        dp.put(key, ways);
        return ways;
    }
}
