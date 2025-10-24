//GFG
//Split Array Subsequences
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.HashMap;
import java.util.Map;

public class SplitArraySubsequences {

    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 3, 4, 5 };
        int k = 2;
        System.out.println(isPossible(arr, k));
    }

    public static boolean isPossible(int[] arr, int k) {
        // Code here
        // Map to store the frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        // Map to store how many subsequences end with a specific number
        Map<Integer, Integer> end = new HashMap<>();
        // Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // Try to build valid subsequences
        for (int num : arr) {
            if (freq.get(num) == 0)
                continue; // Already used
            // Use one occurrence of num
            freq.put(num, freq.get(num) - 1);
            // If there's a subsequence ending at num - 1, extend it
            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
            // Otherwise, try to start a new subsequence of length k
            else {
                boolean canStart = true;
                for (int i = 1; i < k; i++) {
                    if (freq.getOrDefault(num + i, 0) <= 0) {
                        canStart = false;
                        break;
                    }
                }

                if (!canStart)
                    return false;
                // Use up k-1 more consecutive numbers
                for (int i = 1; i < k; i++) {
                    freq.put(num + i, freq.get(num + i) - 1);
                }
                // New subsequence ends at num + k - 1
                end.put(num + k - 1, end.getOrDefault(num + k - 1, 0) + 1);
            }
        }
        return true;
    }
}
