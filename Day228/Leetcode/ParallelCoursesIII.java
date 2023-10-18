//Leetcode
//2050. Parallel Courses III
//Time complexity: O(V+E), where V is the number of courses and E is the number of prerequisite relations. 
//The memoization table ensures that each course's time is calculated only once.
//Space complexity: O(V) for the memoization table and O(E) for the graph.

package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class ParallelCoursesIII {

    public static void main(String[] args) {
        int n = 3;
        int[][] relations = { { 1, 3 }, { 2, 3 } };
        int[] time = { 3, 2, 5 };
        System.out.println(minimumTime(n, relations, time));
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.get(next).add(prev);
        }

        int[] memo = new int[n];
        int overallMinTime = 0;

        for (int i = 0; i < n; i++) {
            overallMinTime = Math.max(overallMinTime, calculateTime(i, graph, time, memo));
        }

        return overallMinTime;
    }

    static int calculateTime(int course, List<List<Integer>> graph, int[] time, int[] memo) {
        if (memo[course] != 0) {
            return memo[course];
        }

        int maxPrerequisiteTime = 0;
        for (int prereq : graph.get(course)) {
            maxPrerequisiteTime = Math.max(maxPrerequisiteTime, calculateTime(prereq, graph, time, memo));
        }

        memo[course] = maxPrerequisiteTime + time[course];
        return memo[course];
    }
}
