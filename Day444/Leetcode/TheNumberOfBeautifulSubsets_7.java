//Leetcode
//2597. The Number of Beautiful Subsets - Iterative DP: Forward
//Time complexity: O(nlogn)
//Space complexity: O(n+k)

import java.util.Map;
import java.util.TreeMap;

public class TheNumberOfBeautifulSubsets_7 {

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
            int prevNum = -k, prev2 = 0, prev1 = 1, curr = 1;
            for (Map.Entry<Integer, Integer> entry : fr.entrySet()) {
                int num = entry.getKey(), f = entry.getValue();
                int skip = prev1;
                int take = ((1 << f) - 1) * (num - prevNum == k ? prev2 : prev1);
                curr = skip + take;
                prev2 = prev1;
                prev1 = curr;
                prevNum = num;
            }
            result *= curr;
        }
        return result - 1;
    }
}
