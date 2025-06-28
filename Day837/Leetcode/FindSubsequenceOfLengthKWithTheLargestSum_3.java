//Leetcode
//2099. Find Subsequence of Length K With the Largest Sum - PriorityQueue/heap
//Time complexity: O(n * logk)
//Space complexity: O(k)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithTheLargestSum_3 {

    public static void main(String[] args) {
        int nums[] = { 2, 1, 3, 3, };
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : pq) {
            freq.merge(n, 1, Integer::sum);
        }
        int[] seq = new int[k];
        int i = 0;
        for (int n : nums) {
            if (freq.merge(n, -1, Integer::sum) >= 0) {
                seq[i++] = n;
            }
        }
        return seq;
    }
}
