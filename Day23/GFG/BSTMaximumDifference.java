//GFG
//BST Maximum Difference
//Time complexity: O(N)
//Space complexity: O(H)

public class BSTMaximumDifference {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(25);
        root.left = new Node(20);
        root.left.left = new Node(15);
        root.left.right = new Node(22);
        root.right = new Node(35);
        root.right.left = new Node(30);
        root.right.left.right = new Node(32);
        root.right.right = new Node(45);

        System.out.println(maxDifferenceBST(root, 20));
    }

    public static int maxDifferenceBST(Node root, int target) {
        // Please code here
        Node[] targetNode = { null };
        int rootToTarget = find(root, target, targetNode);

        if (targetNode[0] == null)
            return -1;

        int targetToLeaf = solve(targetNode[0]);
        return rootToTarget - targetToLeaf;
    }

    public static int find(Node root, int target, Node[] targetNode) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.data == target) {
            targetNode[0] = root;
            return target;
        }

        if (target > root.data)
            return root.data + find(root.right, target, targetNode);
        else
            return root.data + find(root.left, target, targetNode);
    }

    public static int solve(Node root) {
        if (root == null)
            return Integer.MAX_VALUE / 2;
        if (root.left == null && root.right == null)
            return root.data;

        int left = root.data + solve(root.left);
        int right = root.data + solve(root.right);
        return Math.min(left, right);
    }
}
