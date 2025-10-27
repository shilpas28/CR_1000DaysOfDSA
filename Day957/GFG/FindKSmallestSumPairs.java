//GFG
//Find K Smallest Sum Pairs
//Time complexity: O(k*log k)
//Space complexity: O(k)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindKSmallestSumPairs {

    public static void main(String[] args) {
        int arr1[] = { 1, 7, 11 };
        int arr2[] = { 2, 4, 6 };
        int k = 3;
        System.out.println(kSmallestPair(arr1, arr2, k));
    }

    public static ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0 || k == 0)
            return res;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < arr1.length && i < k; i++) {
            minHeap.offer(new int[] { arr1[i] + arr2[0], i, 0 });
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            res.add(pair);
            k--;
            if (j + 1 < arr2.length) {
                minHeap.offer(new int[] { arr1[i] + arr2[j + 1], i, j + 1 });
            }
        }

        return res;
    }
}
