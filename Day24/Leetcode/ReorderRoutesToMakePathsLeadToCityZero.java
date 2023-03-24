import java.util.ArrayList;
import java.util.List;

//Leetcode
//1466. Reorder Routes to Make All Paths Lead to the City Zero
//Time complexity:
//Space complexity:

public class ReorderRoutesToMakePathsLeadToCityZero {

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        System.out.println(minReorder(n, connections));
    }

    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> gr = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            gr.add(new ArrayList<>());
        for (int[] c : connections) {
            gr.get(c[0]).add(c[1]);
            gr.get(c[1]).add(-c[0]);
        }
        return dfs(gr, new boolean[n], 0);
    }

    static int dfs(List<List<Integer>> gr, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : gr.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(gr, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }

}
