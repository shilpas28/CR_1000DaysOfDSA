//Leetcode
//373. Find K Pairs with Smallest Sums
//Time complexity: O(klogk)
//Space complexity: O(k)

package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 }, nums2 = { 2, 4, 6 };
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    static class Pair {
        int[] arr;

        public Pair(int i, int j) {
            arr = new int[2];
            arr[0] = i;
            arr[1] = j;
        }
    }

        public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            int n = nums1.length, m = nums2.length;
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                    (a, b) -> ((nums1[a.arr[0]] + nums2[a.arr[1]]) - (nums2[b.arr[1]] + nums1[b.arr[0]])));
            for (int i = 0; i < n && i < k; i++)
                pq.add(new Pair(i, 0));
            while (k-- > 0 && !pq.isEmpty()) {
                Pair x = pq.poll();
                List<Integer> arr = new ArrayList<>();
                arr.add(nums1[x.arr[0]]);
                arr.add(nums2[x.arr[1]]);
                res.add(arr);
                x.arr[1] += 1;
                if (x.arr[1] < m)
                    pq.add(new Pair(x.arr[0], x.arr[1]));
            }
            return res;
        }
}
