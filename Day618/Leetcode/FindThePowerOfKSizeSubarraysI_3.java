//Leetcode
//3254. Find the Power of K-Size Subarrays I - Monotonic Queue + Sliding Window
//Time complexity: O(n)
//Space complexity: O(k)

package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FindThePowerOfKSizeSubarraysI_3 {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;
        System.out.println(Arrays.toString(resultsArray(nums, k)));
    }

    public static int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums.clone();
        }

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside window
            while (!window.isEmpty() && i - window.peekFirst() >= k) {
                window.pollFirst();
            }
            // Check consecutive sequence
            if (window.isEmpty() || nums[i] - nums[i - 1] == 1) {
                window.offerLast(i);
            } else {
                window.clear();
                window.offerLast(i);
            }
            // Add result when window size is k
            if (i >= k - 1) {
                result.add(window.size() == k ? nums[i] : -1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
