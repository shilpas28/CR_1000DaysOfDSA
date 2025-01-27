//Leetcode
//1462. Course Schedule IV - Tree Traversal Preprocessed
//Time complexity: O((N^3)+Q)
//Space complexity: O(N^2)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleIV_2 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        int[][] queries = { { 0, 1 }, { 1, 0 } };
        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            adjList
                    .computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(edge[1]);
        }

        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        preprocess(numCourses, prerequisites, adjList, isPrerequisite);

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }
        return answer;
    }

    // Iterate over each node and perform BFS starting from it.
    // Mark the starting node as a prerequisite to all the nodes in the BFS
    // traversal.
    static void preprocess(
            int numCourses,
            int[][] prerequisites,
            Map<Integer, List<Integer>> adjList,
            boolean[][] isPrerequisite) {
        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int adj : adjList.getOrDefault(node, new ArrayList<>())) {
                    // If we have marked i as a prerequisite of adj it implies we
                    // have visited it. This is equivalent to using a visited
                    // array.
                    if (!isPrerequisite[i][adj]) {
                        isPrerequisite[i][adj] = true;
                        q.offer(adj);
                    }
                }
            }
        }
    }
}
