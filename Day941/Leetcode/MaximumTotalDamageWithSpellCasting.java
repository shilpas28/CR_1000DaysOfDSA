//Leetcode
//3186. Maximum Total Damage With Spell Casting - TopDown DP 
//Time complexity: 
//Space complexity: 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximumTotalDamageWithSpellCasting {

    public static void main(String[] args) {
        int[] power = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power));
    }

    static long[] DP;

    public static long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Long> hashmap = new TreeMap<>();
        for (int num : power) {
            hashmap.put(num, hashmap.getOrDefault(num, 0L) + num);
        }

        List<long[]> newPowers = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : hashmap.entrySet()) {
            newPowers.add(new long[] { entry.getKey(), entry.getValue() });
        }

        int N = newPowers.size();
        DP = new long[N + 1];
        Arrays.fill(DP, -1);
        return TopDown(0, N, newPowers);
    }

    static long TopDown(int i, int N, List<long[]> P) {
        if (i == N)
            return 0;
        if (DP[i] != -1)
            return DP[i];
        long c1 = TopDown(i + 1, N, P);
        long c2 = P.get(i)[1];
        for (int j = i + 1; j <= Math.min(N - 1, i + 3); j++) {
            if (P.get(j)[0] - P.get(i)[0] > 2) {
                c2 += TopDown(j, N, P);
                break;
            }
        }
        DP[i] = Math.max(c1, c2);
        return DP[i];
    }
}
