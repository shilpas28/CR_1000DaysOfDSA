//Leetcode
//2392. Build a Matrix With Conditions
//Time complexity: O(k+E)
//Space complexity: O(k+E)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BuildAMatrixWithConditions {

    public static void main(String[] args) {
        int k = 3;
        int[][] rowConditions = { { 1, 2 }, { 3, 2 } };
        int[][] colConditions = { { 2, 1 }, { 3, 2 } };
        int[][] res = buildMatrix(k, rowConditions, colConditions);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> order1 = GenerateTopologicalSort(rowConditions, k);
        List<Integer> order2 = GenerateTopologicalSort(colConditions, k);
        if (order1.size() < k || order2.size() < k)
            return new int[0][0];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < k; i++)
            m.put(order2.get(i), i);
        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++)
            ans[i][m.get(order1.get(i))] = order1.get(i);
        return ans;
    }

    static List<Integer> GenerateTopologicalSort(int[][] A, int k) {
        int[] deg = new int[k];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++)
            graph.add(new ArrayList<>());
        Queue<Integer> q = new LinkedList<>();
        for (int[] c : A) {
            graph.get(c[0] - 1).add(c[1] - 1);
            deg[c[1] - 1]++;
        }
        for (int i = 0; i < k; i++)
            if (deg[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int x = q.poll();
            order.add(x + 1);
            for (int y : graph.get(x))
                if (--deg[y] == 0)
                    q.add(y);
        }
        return order;
    }
}
