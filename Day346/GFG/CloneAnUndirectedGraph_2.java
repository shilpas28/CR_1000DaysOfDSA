//GFG
//Clone an Undirected Graph
//Time complexity: O(N+M)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneAnUndirectedGraph_2 {

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
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        HashMap<Node, Node> hm = new HashMap<Node, Node>();
        hm.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node u = q.poll();
            Node cloneNodeU = hm.get(u);
            if (u.neighbors != null) {
                ArrayList<Node> v = u.neighbors;
                for (Node graphNode : v) {
                    Node cloneNodeG = hm.get(graphNode);
                    if (cloneNodeG == null) {
                        q.add(graphNode);
                        cloneNodeG = new Node(graphNode.val);
                        hm.put(graphNode, cloneNodeG);
                    }
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }
        return hm.get(node);
    }
}
