//GFG
//Sum Tree
//Time complexity: O(N)
//Space complexity: O(Height of the Tree)

public class SumTree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
        System.out.println(isSumTree(root));
    }

    static boolean isSum = true;

    static boolean isSumTree(Node root) {
        // Your code here
        isSumTreeUtil(root);
        return isSum;
    }

    static int isSumTreeUtil(Node root) {

        if (isSum == false)
            return 0;

        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.data;

        int lData = isSumTreeUtil(root.left);
        int rData = isSumTreeUtil(root.right);
        if (root.data != lData + rData) {
            isSum = false;
        }
        return root.data + lData + rData;
    }
}
