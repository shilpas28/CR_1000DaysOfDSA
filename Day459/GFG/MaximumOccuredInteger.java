//GFG
//Maximum occured integer - Brute Force - Not accepted as TLE 
//Time complexity: O(N*2)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class MaximumOccuredInteger {

    public static void main(String[] args) {
        int n = 4, maxx = 15;
        int l[] = { 1, 4, 3, 1 }, r[] = { 15, 8, 5, 4 };
        System.out.println(maxOccured(n, l, r, maxx));
    }

    public static int maxOccured(int n, int l[], int r[], int maxx) {
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the map with frequencies of each integer in the ranges
        for (int i = 0; i < n; i++) {
            for (int j = l[i]; j <= r[i]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        int max_freq = Integer.MIN_VALUE;
        int min_ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            int key = x.getKey();
            int freq = x.getValue();

            if (freq > max_freq || (freq == max_freq && key < min_ans)) {
                max_freq = freq;
                min_ans = key;
            }
        }
        return min_ans;
    }
}
