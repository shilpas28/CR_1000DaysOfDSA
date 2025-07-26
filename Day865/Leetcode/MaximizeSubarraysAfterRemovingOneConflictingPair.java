//Leetcode
//3480. Maximize Subarrays After Removing One Conflicting Pair
//Time complexity: O(N+P) where N is the input integer and P is the number of conflicting pairs
//Space complexity: O(N+P) where N is the input integer and P is the number of conflicting pairs

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MaximizeSubarraysAfterRemovingOneConflictingPair {

    public static void main(String[] args) {
        int n = 4;
        int[][] conflictingPairs = { { 2, 3 }, { 1, 4 } };
        System.out.println(maxSubarrays(n, conflictingPairs));
    }

    public static long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }
        for (int[] pair : conflictingPairs) {
            right[Math.max(pair[0], pair[1])].add(Math.min(pair[0], pair[1]));
        }

        long ans = 0;
        long[] left = { 0, 0 }; // left[0] is top1, left[1] is top2
        long[] bonus = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int l_val : right[r]) {
                // Manually update top two values
                if (l_val > left[0]) {
                    left[1] = left[0];
                    left[0] = l_val;
                } else if (l_val > left[1]) {
                    left[1] = l_val;
                }
            }

            ans += r - left[0];

            if (left[0] > 0) {
                bonus[(int) left[0]] += left[0] - left[1];
            }
        }

        long maxBonus = 0;
        for (long b : bonus) {
            maxBonus = Math.max(maxBonus, b);
        }

        return ans + maxBonus;
    }
}
