//GFG
//Bheem Wants Ladoos
//Time complexity: O(N), where N is no. of nodes
//Space complexity: O(1)

package GFG;

public class BheemWantsLadoos {

    // node structure:
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

        int home = 9, K = 1;
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(19);
        root.left.left.left.left = new Node(30);
        root.left.left.right.left = new Node(40);
        root.left.left.right.right = new Node(50);
        root.right = new Node(9);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.right.right.left = new Node(20);
        root.right.right.right = new Node(11);

        System.out.println(ladoos(root, home, K));
    }

    static int ans;

    static int ladoos(Node root, int home, int k) {
        // Your code goes here
        ans = 0;
        solve(root, home, k);
        return ans;
    }

    static int solve(Node root, int home, int k) {
        if (root == null)
            return -1;
        if (root.data == home) {
            ans += findForSubtree(root, k);
            return 0;
        }

        int leftDistance = solve(root.left, home, k);
        int rightDistance = solve(root.right, home, k);
        if (leftDistance != -1) {
            if (leftDistance + 1 <= k)
                ans += root.data + findForSubtree(root.right, k - leftDistance - 2);
            return leftDistance + 1;
        }
        if (rightDistance != -1) {
            if (rightDistance + 1 <= k)
                ans += root.data + findForSubtree(root.left, k - rightDistance - 2);

            return rightDistance + 1;
        }
        return -1;
    }

    static int findForSubtree(Node root, int dis) {
        if (root == null || dis < 0)
            return 0;
        if (dis == 0)
            return root.data;
        return root.data + findForSubtree(root.left, dis - 1) + findForSubtree(root.right, dis - 1);
    }
}
