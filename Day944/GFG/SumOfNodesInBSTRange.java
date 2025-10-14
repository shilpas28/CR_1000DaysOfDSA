//GFG
//Sum of Nodes in BST Range
//Time complexity: O(N)
//Space complexity: O(H)

package GFG;

public class SumOfNodesInBSTRange {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {

        int l = 10, r = 22;
        Node root = new Node(22);
        root.left = new Node(12);
        root.right = new Node(30);
        root.left.left = new Node(8);
        root.left.right = new Node(20);
        System.out.println(nodeSum(root, l, r));
    }

    static int sum = 0;

    public static int nodeSum(Node root, int l, int r) {
        // code here
        dfs(root, l, r);
        return sum;
    }

    static void dfs(Node root, int l, int r) {
        if (root == null)
            return;
        if (root.data >= l && root.data <= r)
            sum += root.data;
        dfs(root.left, l, r);
        dfs(root.right, l, r);
    }
}
