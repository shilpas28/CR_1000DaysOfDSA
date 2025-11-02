//GFG
//Max DAG Edges
//Time complexity: O(1)
//Space complexity: O(1)

public class MaxDAGEdges {

    public static void main(String[] args) {
        int V = 3;
        int edges[][] = { { 0, 1 }, { 1, 2 } };
        System.out.println(maxEdgesToAdd(V, edges));
    }

    public static int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
        return (V * (V - 1)) / 2 - edges.length;
    }
}
