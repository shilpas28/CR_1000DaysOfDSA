//Leetcode
//2192. All Ancestors of a Node in a Directed Acyclic Graph - DFS
//Time complexity: O(N*2)
//Space complexity: O(N*2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {

    public static void main(String[] args) {
        int n = 8;
        int[][] edgeList = { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 6 } };
        System.out.println(getAncestors(n, edgeList));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> parentToKids = new HashMap<>();
        for (int[] e : edges) {
            parentToKids.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < n; ++i) {
            dfs(i, i, ans, parentToKids);
        }
        return ans;
    }

    static void dfs(int ancestor, int kid, List<List<Integer>> ans, Map<Integer, List<Integer>> parentToKids) {
        List<Integer> ancestors = ans.get(kid);
        if (ancestors.isEmpty() || ancestors.get(ancestors.size() - 1) != ancestor) {
            if (ancestor != kid) {
                ancestors.add(ancestor);
            }
            for (int grandKid : parentToKids.getOrDefault(kid, Arrays.asList())) {
                dfs(ancestor, grandKid, ans, parentToKids);
            }
        }
    }
}
