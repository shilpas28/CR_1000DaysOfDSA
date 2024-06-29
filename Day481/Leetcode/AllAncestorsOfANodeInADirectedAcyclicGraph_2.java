//Leetcode
//2192. All Ancestors of a Node in a Directed Acyclic Graph - Topological Sort(BFS)
//Time complexity: O(N*2)
//Space complexity: O(N*2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class AllAncestorsOfANodeInADirectedAcyclicGraph_2 {

    public static void main(String[] args) {
        int n = 8;
        int[][] edgeList = { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 6 } };
        System.out.println(getAncestors(n, edgeList));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Build graph, and compute in degree.
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> parentToKids = new HashMap<>();
        for (int[] e : edges) {
            parentToKids.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            ++inDegree[e[1]];
        }
        // 1. Use a list of sets to save ancestors
        // and to avoid duplicates.
        // 2. Use a Queue to save 0-in-degree nodes as
        // the starting nodes for topological sort.
        List<Set<Integer>> sets = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            sets.add(new HashSet<>());
            if (inDegree[i] == 0)
                q.offer(i);
        }
        // BFS to their neighbors and decrease
        // the in degrees, when reaching 0, add
        // it into queue;
        // During this procedure, get direct parent, add
        // all ancestors of direct parents' of each kid.
        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int kid : parentToKids.getOrDefault(parent, Arrays.asList())) {
                sets.get(kid).add(parent);
                sets.get(kid).addAll(sets.get(parent));
                if (--inDegree[kid] == 0)
                    q.offer(kid);
            }
        }
        // Sort ancestors and put into return list.
        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : sets)
            ans.add(new ArrayList<>(new TreeSet<>(set)));
        return ans;
    }
}
