//GFG
//Clone an Undirected Graph
//Time complexity: O(N+M)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;

public class CloneAnUndirectedGraph {

    static class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public static void main(String[] args) {

    }

    static Node cloneGraph(Node node) {
        Node ans = new Node(node.val);
        HashMap<Integer, Node> vis = new HashMap<>();
        dfs(ans, node, vis);
        return ans;
    }

    static void dfs(Node ans, Node node, HashMap<Integer, Node> vis) {
        vis.put(ans.val, ans);
        for (Node x : node.neighbors) {
            if (vis.get(x.val) == null) {
                Node newNode = new Node(x.val);
                ans.neighbors.add(newNode);
                dfs(newNode, x, vis);
            } else {
                ans.neighbors.add(vis.get(x.val));
            }
        }
    }
}
