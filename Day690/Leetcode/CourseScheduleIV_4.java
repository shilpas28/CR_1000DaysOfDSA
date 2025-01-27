//Leetcode
//1462. Course Schedule IV - Floyd Warshall Algorithm
//Time complexity: O((N^3)+Q)
//Space complexity: O(N^2)

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV_4 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        int[][] queries = { { 0, 1 }, { 1, 0 } };
        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        for (int[] edge : prerequisites) {
            isPrerequisite[edge[0]][edge[1]] = true;
        }

        for (int intermediate = 0; intermediate < numCourses; intermediate++) {
            for (int src = 0; src < numCourses; src++) {
                for (int target = 0; target < numCourses; target++) {
                    // If there is a path i -> intermediate and intermediate -> j, then i -> j
                    // exists as well.
                    isPrerequisite[src][target] = isPrerequisite[src][target] ||
                            (isPrerequisite[src][intermediate] &&
                                    isPrerequisite[intermediate][target]);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }
        return answer;
    }
}
