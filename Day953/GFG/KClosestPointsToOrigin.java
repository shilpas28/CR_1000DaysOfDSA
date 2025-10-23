//GFG
//K Closest Points to Origin
//Time complexity: O(nlogk)
//Space complexity: O(k)

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int k = 2;
        int points[][] = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
        System.out.println(kClosest(points, k));
    }

    static class Pair {
        double dist;
        int point[];

        Pair(double dist, int point[]) {
            this.dist = dist;
            // Good coding practise
            this.point = new int[point.length];
            for (int i = 0; i < point.length; i++) {
                this.point[i] = point[i];
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        // code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        for (int i[] : points) {
            double eDist = (double) i[0] * i[0] + i[1] * i[1];
            minHeap.add(new Pair(Math.sqrt(eDist), i));
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (k-- != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            Pair p = minHeap.poll();
            // Good coding practise
            if (p.point.length == 2) {
                temp.add(p.point[0]);
                temp.add(p.point[1]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
