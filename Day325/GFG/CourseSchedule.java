//GFG
//Course Schedule
//Time complexity:
//Space complexity: 

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int n = 2, m = 1;
        // prerequisites = {{1, 0}}
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(new ArrayList<>(Arrays.asList(0, 1)));
        System.out.println(Arrays.toString(findOrder(n, m, prerequisites)));
    }

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // add your code here
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[n];
        int ind = 0;
        // o(v + e)
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[ind++] = node;
            // node is in your topo sort
            // so please remove it from the indegree
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        if (ind == n)
            return topo;
        int[] arr = {};
        return arr;
    }
}
