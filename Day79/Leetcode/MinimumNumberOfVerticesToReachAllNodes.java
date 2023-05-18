//Leetcode
//1557. Minimum Number of Vertices to Reach All Nodes
//Time complexity: O(E)
//Space complexity: O(V)

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(0);
        edge1.add(1);
        edges.add(edge1);
        List<Integer> edge2 = new ArrayList<>();
        edge1.add(0);
        edge1.add(2);
        edges.add(edge2);
        List<Integer> edge3 = new ArrayList<>();
        edge1.add(2);
        edge1.add(5);
        edges.add(edge3);
        List<Integer> edge4 = new ArrayList<>();
        edge1.add(3);
        edge1.add(4);
        edges.add(edge4);
        List<Integer> edge5 = new ArrayList<>();
        edge1.add(4);
        edge1.add(2);
        edges.add(edge5);
        // edges = [[0,1],[0,2],[2,5],[3,4],[4,2]];
        System.out.println(findSmallestSetOfVertices(n, edges));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean indegree[] = new boolean[n];
        for (int i = 0; i < edges.size(); i++) {
            int to = edges.get(i).get(1);
            indegree[to] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!indegree[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
