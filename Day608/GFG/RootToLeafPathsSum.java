//GFG
//Root to leaf paths sum
//Time complexity: O(N)
//Space complexity: O(H)

public class RootToLeafPathsSum {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.right = new Node(4);
        System.out.println(treePathsSum(root));
    }

    public static int treePathsSum(Node root) {
        // add code here.
        return help(root, 0);
    }

    static int help(Node root, int num) {
        if (root == null)
            return 0;
        num = num * 10 + root.data;
        if (root.left == null && root.right == null)
            return num;
        return help(root.left, num) + help(root.right, num);
    }
}
