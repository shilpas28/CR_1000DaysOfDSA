//Leetcode
//1514. Path with Maximum Probability - Dijkstra's algorithm
//Time complexity: O(ElogV)
//Space complexity: O(E)

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

    public static void main(String[] args) {
        int n = 3, start = 0, end = 2;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(prob[b], prob[a]));
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(new int[] { edges[i][1], i });
            adjList[edges[i][1]].add(new int[] { edges[i][0], i });
        }
        prob[start] = 1;
        maxHeap.offer(start);

        while (!maxHeap.isEmpty()) {
            int cur = maxHeap.poll();
            for (int[] nei : adjList[cur]) {
                if (prob[cur] * succProb[nei[1]] > prob[nei[0]]) {
                    prob[nei[0]] = prob[cur] * succProb[nei[1]];
                    maxHeap.offer(nei[0]);
                }
            }
        }
        return prob[end];
    }
}
