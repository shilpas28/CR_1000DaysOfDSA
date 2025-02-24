//Leetcode
//2467. Most Profitable Path in a Tree - Two Depth-First Searches
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostProfitablePathInATree_2 {

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
        int bob = 3;
        int[] amount = { -2, 4, 2, -4, 6 };
        System.out.println(mostProfitablePath(edges, bob, amount));
    }

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        // Form tree with edges
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        // Find the path taken by Bob to reach node 0 and the times it takes to get
        // there
        findBobPath(bob, 0);
        // Find Alice's optimal path
        Arrays.fill(visited, false);
        findAlicePath(0, 0, 0, amount);

        return maxIncome;
    }

    static Map<Integer, Integer> bobPath;
    static boolean[] visited;
    static List<List<Integer>> tree;
    static int maxIncome = Integer.MIN_VALUE;

    // Depth First Search to find Bob's path
    static boolean findBobPath(int sourceNode, int time) {
        // Mark and set time node is reached
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;
        // Destination for Bob is found
        if (sourceNode == 0) {
            return true;
        }
        // Traverse through unvisited nodes
        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode] && findBobPath(adjacentNode, time + 1)) {
                return true;
            }
        }
        // If node 0 isn't reached, remove current node from path
        bobPath.remove(sourceNode);
        return false;
    }

    // Depth First Search to find Alice's optimal path
    static void findAlicePath(
            int sourceNode,
            int time,
            int income,
            int[] amount) {
        // Mark node as explored
        visited[sourceNode] = true;
        // Alice reaches the node first
        if (!bobPath.containsKey(sourceNode) || time < bobPath.get(sourceNode)) {
            income += amount[sourceNode];
        }
        // Alice and Bob reach the node at the same time
        else if (time == bobPath.get(sourceNode)) {
            income += amount[sourceNode] / 2;
        }
        // Update max value if current node is a new leaf
        if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
            maxIncome = Math.max(maxIncome, income);
        }
        // Traverse through unvisited nodes
        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode]) {
                findAlicePath(adjacentNode, time + 1, income, amount);
            }
        }
    }
}
