//Leetcode
//2597. The Number of Beautiful Subsets - DP: Recursion + Memoization
//Time complexity: O(nlogn+n)=O(nlogn)
//Space complexity: O(n+k)

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class TheNumberOfBeautifulSubsets_4 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6 };
        int k = 2;
        System.out.println(beautifulSubsets(nums, k));
    }

    static int[][] s;
    static int[] count;

    public static int beautifulSubsets(int[] nums, int k) {
        int result = 1;
        Map<Integer, Map<Integer, Integer>> freq = new TreeMap<>();
        for (int x : nums) {
            Map<Integer, Integer> fr = freq.getOrDefault(x % k, new TreeMap<>());
            fr.put(x, fr.getOrDefault(x, 0) + 1);
            freq.put(x % k, fr);
        }
        for (Map<Integer, Integer> fr : freq.values()) {
            s = fr.entrySet().stream()
                    .map(e -> new int[] { e.getKey(), e.getValue() })
                    .toArray(int[][]::new);
            count = new int[fr.size()];
            Arrays.fill(count, -1);
            result *= beautifulSubsets(s.length, k, 0);
        }
        return result - 1;
    }

    static int beautifulSubsets(int n, int k, int i) {
        if (i == n) {
            return 1;
        }
        if (count[i] != -1) {
            return count[i];
        }
        int skip = beautifulSubsets(n, k, i + 1);
        int take = (1 << s[i][1]) - 1;
        if (i + 1 < n && s[i + 1][0] - s[i][0] == k) {
            take *= beautifulSubsets(n, k, i + 2);
        } else {
            take *= beautifulSubsets(n, k, i + 1);
        }
        return count[i] = skip + take;
    }
}
