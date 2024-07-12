//GFG
//Root to leaf path sum
//Time complexity: O(n)
//Space complexity: O(height of tree)

public class RootToLeafPathSum {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        int target = 2;
        System.out.println(hasPathSum(root, target));
    }

    /* you are required to complete this function */
    static boolean hasPathSum(Node root, int target) {
        // Your code here
        if (root == null || target < 0)
            return false;

        if (root.left == null && root.right == null)
            if (target - root.data == 0)
                return true;
            else
                return false;

        return hasPathSum(root.left, target - root.data) || hasPathSum(root.right, target - root.data);
    }
}
