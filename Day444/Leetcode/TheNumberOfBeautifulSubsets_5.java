//Leetcode
//2597. The Number of Beautiful Subsets - Iterative DP
//Time complexity: O(nlogn)
//Space complexity: O(n+k)

import java.util.Map;
import java.util.TreeMap;

public class TheNumberOfBeautifulSubsets_5 {

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
            int n = fr.size();
            int[][] s = fr.entrySet().stream()
                    .map(e -> new int[] { e.getKey(), e.getValue() })
                    .toArray(int[][]::new);
            int[] count = new int[n + 1];
            count[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                int skip = count[i + 1];
                int take = (1 << s[i][1]) - 1;
                if (i + 1 < n && s[i + 1][0] - s[i][0] == k) {
                    take *= count[i + 2];
                } else {
                    take *= count[i + 1];
                }
                count[i] = skip + take;
            }
            result *= count[0];
        }
        return result - 1;
    }
}
