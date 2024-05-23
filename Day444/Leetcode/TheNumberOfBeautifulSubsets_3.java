//Leetcode
//2597. The Number of Beautiful Subsets - Recursion Optimized 
//Time complexity: O(nlogn+2^n) = O(2^n)
//Space complexity: O(n+k)

import java.util.Map;
import java.util.TreeMap;

public class TheNumberOfBeautifulSubsets_3 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6 };
        int k = 2;
        System.out.println(beautifulSubsets(nums, k));
    }

    static int[][] s;

    public static int beautifulSubsets(int[] nums, int k) {
        int result = 1;
        Map<Integer, Map<Integer, Integer>> freq = new TreeMap<>();
        // {remainder : {num : frequency}}
        // map is sorted based on num to get subset of form [x, x + k, x + 2k, ...]
        for (int x : nums) { // splitting subsets based on remainder and calculating frequency
            Map<Integer, Integer> fr = freq.getOrDefault(x % k, new TreeMap<>());
            fr.put(x, fr.getOrDefault(x, 0) + 1);
            freq.put(x % k, fr);
        }
        for (Map<Integer, Integer> fr : freq.values()) { // loop for s1, s2, ...
            s = fr.entrySet().stream()
                    .map(e -> new int[] { e.getKey(), e.getValue() })
                    .toArray(int[][]::new);
            result *= beautifulSubsets(s.length, k, 0); // f(s1) * f(s2) ...
        }
        return result - 1; // -1 for empty subset
    }

    static int beautifulSubsets(int n, int k, int i) {
        if (i == n) {
            return 1;
        }
        int skip = beautifulSubsets(n, k, i + 1); // 1 * f(i + 1)
        int take = (1 << s[i][1]) - 1; // take s[i]
        if (i + 1 < n && s[i + 1][0] - s[i][0] == k) { // next number is s[i] + k
            take *= beautifulSubsets(n, k, i + 2);
        } else {
            take *= beautifulSubsets(n, k, i + 1);
        }
        return skip + take;
    }
}
