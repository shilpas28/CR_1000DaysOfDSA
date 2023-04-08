//Leetcode 
//133. Clone Graph - using DFS
//Time complexity: O(E*V)
//Space complexity: O(E*V + 2*V + V)

package Leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph_1 {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        // Node adjList = {{2,4},{1,3},{2,4},{1,3}};
        // Node node = new Node(1,{2,4});
    }

    static HashMap<Node, Node> mp = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (mp.containsKey(node))
            return mp.get(node);
        mp.put(node, new Node(node.val));
        for (Node val : node.neighbors) {
            mp.get(node).neighbors.add(cloneGraph(val));
        }
        return mp.get(node);
    }
}
