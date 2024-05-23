//Leetcode
//2597. The Number of Beautiful Subsets - Iterative DP Space Optimized
//Time complexity: O(nlogn)
//Space complexity: O(n+k)

import java.util.Map;
import java.util.TreeMap;

public class TheNumberOfBeautifulSubsets_6 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6 };
        int k = 2;
        System.out.println(beautifulSubsets(nums, k));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        int result = 1;
        Map<Integer, Map<Integer, Integer>> freq = new TreeMap<>();
        for (int x : nums) {
            Map<Integer, Integer> fr = freq.getOrDefault(x % k, new TreeMap<>());
            fr.put(x, fr.getOrDefault(x, 0) + 1);
            freq.put(x % k, fr);
        }
        for (Map<Integer, Integer> fr : freq.values()) {
            int n = fr.size(), curr = 1, next1 = 1, next2 = 0;
            int[][] s = fr.entrySet().stream()
                    .map(e -> new int[] { e.getKey(), e.getValue() })
                    .toArray(int[][]::new);
            for (int i = n - 1; i >= 0; i--) {
                int skip = next1;
                int take = (1 << s[i][1]) - 1;
                if (i + 1 < n && s[i + 1][0] - s[i][0] == k) {
                    take *= next2;
                } else {
                    take *= next1;
                }
                curr = skip + take;
                next2 = next1;
                next1 = curr;
            }
            result *= curr;
        }
        return result - 1;
    }
}
