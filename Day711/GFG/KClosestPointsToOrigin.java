//GFG
//K Closest Points to Origin
//Time complexity: O(NlogK)
//Space complexity: O(K)

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int k = 2;
        int[][] points = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
        int[][] res = kClosest(points, k);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));
        for (int[] pt : points) {
            pq.add(pt);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
