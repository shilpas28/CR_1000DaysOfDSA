//Leetcode
//3186. Maximum Total Damage With Spell Casting - Compressing The States
//Time complexity: 
//Space complexity: 

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximumTotalDamageWithSpellCasting_6 {

    public static void main(String[] args) {
        int[] power = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power));
    }

    public static long maximumTotalDamage(int[] power) {
        List<long[]> A = compress(power);

        int N = 3 * A.size();
        long[] DP = new long[N + 1];
        for (long[] PD : A)
            DP[(int) PD[0]] = PD[1];

        for (int P = 1; P <= N; P++) {
            if (P >= 3)
                DP[P] += DP[P - 3];
            DP[P] = Math.max(DP[P], DP[P - 1]);
        }

        long maxElement = 0;
        for (long value : DP) {
            maxElement = Math.max(maxElement, value);
        }

        return maxElement;
    }

    public static List<long[]> compress(int[] A) {
        TreeMap<Integer, Long> mp = new TreeMap<>();
        for (int num : A) {
            mp.put(num, mp.getOrDefault(num, 0L) + num);
        }

        int NP = 1, LP = 0;
        List<long[]> newA = new ArrayList<>();

        for (Map.Entry<Integer, Long> entry : mp.entrySet()) {
            int P = entry.getKey();
            long D = entry.getValue();
            NP = NP + (LP != 0 ? Math.min(3, P - LP) : 0);
            newA.add(new long[] { NP, D });
            LP = P;
        }

        return newA;
    }
}
