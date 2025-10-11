//Leetcode
//3186. Maximum Total Damage With Spell Casting - BottomUp DP
//Time complexity:
//Space complexity:

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximumTotalDamageWithSpellCasting_2 {

    public static void main(String[] args) {
        int[] power = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power));
    }

    public static long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Long> hashmap = new TreeMap<>();
        for (int num : power)
            hashmap.put(num, hashmap.getOrDefault(num, 0L) + num);

        List<long[]> newPowers = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : hashmap.entrySet()) {
            newPowers.add(new long[] { entry.getKey(), entry.getValue() });
        }

        return BottomUp(newPowers.size(), newPowers);
    }

    static long BottomUp(int N, List<long[]> P) {
        long[] DP = new long[N + 1];
        for (int i = 0; i < N; i++) {
            long c1 = i > 0 ? DP[i - 1] : 0;
            long c2 = P.get(i)[1];
            for (int j = i - 1; j >= Math.max(0, i - 3); j--) {
                if (P.get(i)[0] - P.get(j)[0] > 2) {
                    c2 += DP[j];
                    break;
                }
            }
            DP[i] = Math.max(c1, c2);
        }
        return DP[N - 1];
    }
}
