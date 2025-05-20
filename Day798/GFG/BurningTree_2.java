//GFG
//Burning Tree
//Time complexity: O(number of nodes)
//Space complexity: O(height of tree)

public class BurningTree_2 {

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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int target = 2;
        System.out.println(minTime(root, target));

    }

    static int ans = 0;

    public static int minTime(Node root, int target) {
        // code here
        ans = 0;
        traverse(root, target);
        return ans;
    }

    public static int traverse(Node node, int target) {

        // base case
        if (node == null)
            return 0;
        // target found, hence returning distance from it
        if (node.data == target) {
            ans = Math.max(ans, maxDepth(node.right));
            ans = Math.max(ans, maxDepth(node.left));
            return 1;
        }

        int val = traverse(node.left, target);
        // (val != 0) means target was found at distance = val
        if (val != 0) {

            // finding max Depth on right as target was on left
            ans = Math.max(ans, val + maxDepth(node.right));
            return val + 1;
        }
        val = traverse(node.right, target);
        // (val != 0) means target was found at distance = val
        if (val != 0) {
            // finding max Depth on left as target was on right
            ans = Math.max(ans, val + maxDepth(node.left));
            return val + 1;
        }
        return 0;
    }

    public static int maxDepth(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
