//Leetcode
//3186. Maximum Total Damage With Spell Casting - Storing Last Three States 
//Time complexity:
//Space complexity:

import java.util.Map;
import java.util.TreeMap;

public class MaximumTotalDamageWithSpellCasting_4 {

    public static void main(String[] args) {
        int[] power = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power));
    }

    public static long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Long> hashmap = new TreeMap<>();
        for (int p : power) {
            hashmap.put(p, hashmap.getOrDefault(p, 0L) + p);
        }
        // {power, maximumDamage}
        long[][] dp = new long[3][2];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        long maxi = 0;

        for (Map.Entry<Integer, Long> entry : hashmap.entrySet()) {
            int P = entry.getKey();
            long F = entry.getValue();
            long[] newDP = { P, F };
            // when we pick this power
            for (int j = 2; j >= 0 && dp[j][0] != -1; j--) {
                if (P - dp[j][0] > 2) {
                    newDP[1] += dp[j][1];
                    break;
                }
            }
            // when we do not pick this power
            newDP[1] = Math.max(newDP[1], dp[2][1]);
            // update maximumDamage
            maxi = Math.max(maxi, newDP[1]);
            // update dp states
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = newDP;
        }

        return maxi;
    }
}
