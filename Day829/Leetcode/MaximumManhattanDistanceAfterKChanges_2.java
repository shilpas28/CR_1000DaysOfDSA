//Leetcode
//3443. Maximum Manhattan Distance After K Changes - 1 iteration
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.HashMap;
import java.util.Map;

public class MaximumManhattanDistanceAfterKChanges_2 {

    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        System.out.println(maxDistance(s, k));
    }

    public static int maxDistance(String s, int k) {
        int ans = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            int diff = Math.abs(freq.getOrDefault('N', 0) - freq.getOrDefault('S', 0))
                    + Math.abs(freq.getOrDefault('E', 0) - freq.getOrDefault('W', 0));
            ans = Math.max(ans, diff + Math.min(2 * k, i + 1 - diff));
        }
        return ans;
    }
}
