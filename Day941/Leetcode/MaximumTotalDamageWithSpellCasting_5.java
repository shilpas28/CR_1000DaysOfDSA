//Leetcode
//3186. Maximum Total Damage With Spell Casting - Padding Extra States
//Time complexity: 
//Space complexity: 

import java.util.TreeMap;

public class MaximumTotalDamageWithSpellCasting_5 {

    public static void main(String[] args) {
        int[] power = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power));
    }

    public static long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Long> dp = new TreeMap<>();
        for (int P : power) {
            dp.put(P, dp.getOrDefault(P, 0L) + P);
            dp.put(P - 3, Math.max(0L, dp.getOrDefault(P - 3, 0L)));
        }

        long maxi = 0, last = 0;

        for (int P : dp.keySet()) {
            dp.put(P, last = Math.max(dp.get(P) + dp.getOrDefault(P - 3, 0L), last));
            maxi = Math.max(maxi, last);
        }

        return maxi;
    }
}
