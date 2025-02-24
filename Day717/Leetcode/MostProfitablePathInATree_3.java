//Leetcode
//2467. Most Profitable Path in a Tree - Depth-First Search
//Time complexity: O(N)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.List;

public class MostProfitablePathInATree_3 {

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 } };
        int bob = 3;
        int[] amount = { -2, 4, 2, -4, 6 };
        System.out.println(mostProfitablePath(edges, bob, amount));
    }

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        distanceFromBob = new int[n];
        // Form tree with edges
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return findPaths(0, 0, 0, bob, amount);
    }

    static List<List<Integer>> tree;
    static int[] distanceFromBob;
    static int n;

    // Depth-first Search
    static int findPaths(
            int sourceNode,
            int parentNode,
            int time,
            int bob,
            int[] amount) {
        int maxIncome = 0, maxChild = Integer.MIN_VALUE;
        // Find the node distances from Bob
        if (sourceNode == bob) {
            distanceFromBob[sourceNode] = 0;
        } else {
            distanceFromBob[sourceNode] = n;
        }

        for (int adjacentNode : tree.get(sourceNode)) {
            if (adjacentNode != parentNode) {
                maxChild = Math.max(
                        maxChild,
                        findPaths(adjacentNode, sourceNode, time + 1, bob, amount));
                distanceFromBob[sourceNode] = Math.min(
                        distanceFromBob[sourceNode],
                        distanceFromBob[adjacentNode] + 1);
            }
        }
        // Alice reaches the node first
        if (distanceFromBob[sourceNode] > time) {
            maxIncome += amount[sourceNode];
        }
        // Alice and Bob reach the node at the same time
        else if (distanceFromBob[sourceNode] == time) {
            maxIncome += amount[sourceNode] / 2;
        }
        // Return max income of leaf node
        return (maxChild == Integer.MIN_VALUE)
                ? maxIncome
                : maxIncome + maxChild;
    }
}
