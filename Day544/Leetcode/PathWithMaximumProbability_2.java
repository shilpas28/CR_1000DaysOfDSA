//Leetcode
//1514. Path with Maximum Probability - Dijkstra
//Time complexity: O((n + E) * logE), where E = edges.length
//Space complexity: O(n + E), where E = edges.length

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMaximumProbability_2 {

    static class State {
        int node;
        double prob;

        State(int _node, double _prob) {
            node = _node;
            prob = _prob;
        }
    }

    public static void main(String[] args) {
        int n = 3, start = 0, end = 2;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // build graph -> double[0]: node, double[1]: parent-to-node prob
        Map<Integer, List<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];

            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(new double[] { edge[1], succProb[i] });
            map.get(edge[1]).add(new double[] { edge[0], succProb[i] });
        }

        double[] probs = new double[n]; // best prob so far for each node
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> (((Double) b.prob).compareTo((Double) a.prob)));
        pq.add(new State(start_node, 1.0));

        while (!pq.isEmpty()) {

            State state = pq.poll();
            int parent = state.node;
            double prob = state.prob;

            if (parent == end_node)
                return prob;

            for (double[] child : map.getOrDefault(parent, new ArrayList<>())) {
                // add to pq only if: it can make a better prob
                if (probs[(int) child[0]] >= prob * child[1])
                    continue;
                pq.add(new State((int) child[0], prob * child[1]));
                probs[(int) child[0]] = prob * child[1];
            }
        }
        return 0;
    }
}
