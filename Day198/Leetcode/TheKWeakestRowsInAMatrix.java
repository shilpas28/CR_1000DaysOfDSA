//leetcode - using Priority Queue
//1337. The K Weakest Rows in a Matrix
//Time complexity: O(M*N) where M = rows and N = columns
//Space complexity: O(M) where M = rows and N = columns

package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] res = new int[k];

        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else
                    break;
            }
            pq.offer(new int[] { soldiers, i });
        }

        while (pq.size() > k) {
            pq.poll();
        }

        while (k > 0)
            res[--k] = pq.poll()[1];

        return res;
    }
}
