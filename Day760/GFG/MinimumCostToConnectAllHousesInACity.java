//GFG
//Minimum cost to connect all houses in a city
//Time complexity: O((N^2)logN)
//Space complexity: O(N^2)

package GFG;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectAllHousesInACity {

    public static void main(String[] args) {
        int houses[][] = { { 0, 7 }, { 0, 9 }, { 20, 7 }, { 30, 7 }, { 40, 70 } };
        System.out.println(minCost(houses));
    }

    public static int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        int totalCost = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        visited[0] = true;
        for (int i = 1; i < n; i++) {
            int cost = Math.abs(houses[0][0] - houses[i][0]) + Math.abs(houses[0][1] - houses[i][1]);
            minHeap.add(new int[] { cost, i });
        }

        int edgeCount = 0;
        while (edgeCount < n - 1) {
            int[] edge = minHeap.poll();
            int cost = edge[0];
            int houseIdx = edge[1];

            if (visited[houseIdx])
                continue;

            visited[houseIdx] = true;
            totalCost += cost;
            edgeCount++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int newCost = Math.abs(houses[houseIdx][0] - houses[i][0])
                            + Math.abs(houses[houseIdx][1] - houses[i][1]);
                    minHeap.add(new int[] { newCost, i });
                }
            }
        }

        return totalCost;
    }
}
