//Leetcode
//Tallest Billboard 
//Time complexity: O(N*S)
//Space complexity: O(N*S)

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class TallestBillboard {

    public static void main(String[] args) {
        int[] rods = { 1, 2, 3, 6 };
        System.out.println(tallestBillboard(rods));
    }

    public static int tallestBillboard(int[] rods) {
        int n = rods.length;
        return solve(0, 0, n, rods) / 2;
    }

    static Map<String, Integer> dp = new HashMap<>();

    public static int solve(int idx, int diff, int n, int[] rods) {
        String key = idx + ":" + diff;
        if (dp.containsKey(key))
            return dp.get(key);
        if (idx == n) {
            return diff == 0 ? 0 : Integer.MIN_VALUE;
        }
        int res = Math.max(
                solve(idx + 1, diff + rods[idx], n, rods) + rods[idx],
                Math.max(solve(idx + 1, diff - rods[idx], n, rods) + rods[idx],
                        solve(idx + 1, diff, n, rods)));
        dp.put(key, res);
        return res;
    }
}
