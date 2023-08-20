//leetcode
//1203. Sort Items by Groups Respecting Dependencies
//Time complexity: O(V+E)
//Space complexity: O(V+E)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SortItemsByGroupsRespectingDependencies {

    public static void main(String[] args) {
        int n = 8, m = 2;
        int[] group = { -1, -1, 1, 0, 0, 1, 0, -1 };
        // int[][] beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
        List<List<Integer>> beforeItems = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        beforeItems.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        beforeItems.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        beforeItems.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(6);
        beforeItems.add(list4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(6);
        beforeItems.add(list5);
        List<Integer> list6 = new ArrayList<>();
        beforeItems.add(list6);
        List<Integer> list7 = new ArrayList<>();
        beforeItems.add(list7);
        List<Integer> list8 = new ArrayList<>();
        beforeItems.add(list8);
        System.out.println(Arrays.toString(sortItems(n, m, group, beforeItems)));
    }

    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId++;
            }
        }
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;
                if (group[i] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }
        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                stack.add(i);
            }
        }
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);
            for (Integer n : graph.get(curr)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    stack.add(n);
                }
            }
        }
        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}
