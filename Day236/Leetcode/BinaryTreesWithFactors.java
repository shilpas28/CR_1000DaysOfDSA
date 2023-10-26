//Leetcode
//823. Binary Trees With Factors
//Time complexity: O(N^2)
//Space complexity: O(N)

package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {

    public static void main(String[] args) {
        int[] arr = { 2, 4 };
        System.out.println(numFactoredBinaryTrees(arr));
    }

    public static int numFactoredBinaryTrees(int[] arr) {
        long res = 0L, mod = (long) 1e9 + 7;
        Arrays.sort(arr);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; ++j)
                if (arr[i] % arr[j] == 0)
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % mod);
            res = (res + dp.get(arr[i])) % mod;
        }
        return (int) res;
    }
}
