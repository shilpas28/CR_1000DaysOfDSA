//GFG
//Subtree In N-ary Tree
//Time complexity: O(N)
//Space complexity: O(N^2)

package GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubtreeInNAryTree {
    static class Node {
        int data;
        List<Node> children;

        Node(int val) {
            this.data = val;
            this.children = new ArrayList<>();
        }
    }

    static class N_ary_Tree {
        Node root;
        int size;

        N_ary_Tree() {
            this.size = 0;
            this.root = null;
        }

        Node add(int key, Node parent) {
            Node node = new Node(key);
            if (parent == null) {
                this.root = node;
                this.size = 1;
            } else {
                parent.children.add(node);
                this.size++;
            }
            return node;
        }
    }

    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s[] = br.readLine().trim().split(" ");
            N_ary_Tree tree = new N_ary_Tree();
            Node curr = null;
            Queue<Node> q = new LinkedList<>();
            for (int i = 0; i < s.length; i++) {
                if (i == 0) {
                    curr = tree.add(Integer.parseInt(s[0]), null);
                } else if (s[i].equals(" ")) {
                    continue;
                } else if (!q.isEmpty() && s[i].equals("N")) {
                    curr = q.remove();
                } else if (!s[i].equals("N")) {
                    q.add(tree.add(Integer.parseInt(s[i]), curr));
                }
            }
            SubtreeInNAryTree soln = new SubtreeInNAryTree();
            ot.println(soln.duplicateSubtreeNaryTree(tree.root));
        }

        ot.close();
    }

    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public int duplicateSubtreeNaryTree(Node root) {
        // Code here
        solve(root);
        int ans = 0;
        for (int val : map.values()) {
            if (val > 1) {
                ans++;
            }
        }
        return ans;
    }

    static String solve(Node root) {
        if (root == null) {
            return "";
        }
        String returnValue = Integer.toString(root.data);

        for (Node child : root.children) {
            returnValue += "#" + solve(child);
        }

        map.put(returnValue, map.getOrDefault(returnValue, 0) + 1);
        return returnValue;
    }

}
