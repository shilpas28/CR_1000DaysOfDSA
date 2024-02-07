//GFG
//Min distance between two given nodes of a Binary Tree - Using DFS
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

package GFG;

public class MinDistanceBetween2GivenNodesOfABinaryTree_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(22);
        root.right = new Node(33);
        root.left.left = new Node(44);
        root.left.right = new Node(55);
        root.right.left = new Node(66);
        root.right.right = new Node(77);
        int a = 77, b = 22;
        System.out.println(findDist(root, a, b));
    }

    static int findDist(Node root, int a, int b) {
        // Your code here
        Node LCA = lca(root, a, b);
        return findLevel(LCA, a, 0) + findLevel(LCA, b, 0); //dfs 
    }

    static Node lca(Node root, int n1, int n2) {
        // Your code here
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null)
            return root;

        if (left != null && right == null)
            return left;
        else
            return right;
    }

    static int findLevel(Node root, int data, int level) // to find the distance from the one node to another node with data
                                                  // d.
    {
        if (root == null) //
            return -1;

        if (root.data == data)
            return level;

        int left = findLevel(root.left, data, level + 1);
        int right = findLevel(root.right, data, level + 1);

        if (left == -1)
            return right;
        else
            return left;
    }

}
