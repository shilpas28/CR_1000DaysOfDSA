//Leetcode
//3272. Find the Count of Good Integers
//Time complexity: O((10^(n/2))*n)
//Space complexity: O(n)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheCountOfGoodIntegers {

    public static void main(String[] args) {
        int n = 3, k = 5;
        System.out.println(countGoodIntegers(n, k));
    }

    static long res = 0;
    static Set<String> visited = new HashSet<>();

    public static long countGoodIntegers(int n, int k) {
        res = 0;
        visited.clear();
        genPal(new int[n], 0, n - 1, k, n);
        return res;
    }

    static void genPal(int[] palin, int left, int right, int divisor, int total) {
        if (left > right) {
            long val = vectorToNumber(palin);
            if (val % divisor == 0) {
                Map<Integer, Integer> freq = new HashMap<>();
                for (int d : palin)
                    freq.put(d, freq.getOrDefault(d, 0) + 1);
                String key = freq.toString();
                if (!visited.contains(key)) {
                    res += totalPermutations(freq, total) - permsWithZero(new HashMap<>(freq), total);
                    visited.add(key);
                }
            }
            return;
        }

        for (int d = (left == 0 ? 1 : 0); d <= 9; d++) {
            palin[left] = palin[right] = d;
            genPal(palin, left + 1, right - 1, divisor, total);
        }
    }

    static long vectorToNumber(int[] digits) {
        long num = 0;
        for (int d : digits)
            num = num * 10 + d;
        return num;
    }

    static long totalPermutations(Map<Integer, Integer> freq, int total) {
        long res = fact(total);
        for (int count : freq.values())
            res /= fact(count);
        return res;
    }

    static long fact(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }

    static long permsWithZero(Map<Integer, Integer> freq, int total) {
        if (!freq.containsKey(0) || freq.get(0) == 0)
            return 0;
        freq.put(0, freq.get(0) - 1);
        long res = fact(total - 1);
        for (int count : freq.values())
            res /= fact(count);
        return res;
    }
}
