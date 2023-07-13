//Leetcode
//207. Course Schedule
//Time complexity: O(V+E)
//Space complexity: O(V+E)

package Leetcode;

import java.util.ArrayList;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i)
            adj[i] = new ArrayList();
        for (int[] pre : prerequisites)
            adj[pre[0]].add(pre[1]);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0 && !dfs(adj, visited, i))
                return false;
        }
        return true;
    }

    public static boolean dfs(ArrayList<Integer>[] adj, int[] visited, int v) {
        if (visited[v] == 1)
            return false;
        if (visited[v] == 2)
            return true;
        visited[v] = 1;
        for (int ad : adj[v])
            if (!dfs(adj, visited, ad))
                return false;
        visited[v] = 2;
        return true;
    }
}
