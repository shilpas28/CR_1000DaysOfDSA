//GFG
//Check if all leaves are at same level - Using DFS
//Time complexity: O(n)
//Space complexity: O(height of tree)

package GFG;

public class CheckIfAllLeavesAreAtSameLevel {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        // tree 1
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        // tree 2
        Node root1 = new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        root1.left.left = new Node(10);
        root1.left.right = new Node(15);
        // function calls
        System.out.println(check(root));
        System.out.println(check(root1));
    }

    static boolean sameLevel = true;
    static int leafLevel = -1;
    static int h = 0;

    static boolean check(Node root) {
        // Your code here
        height(root, h);
        return sameLevel;
    }

    static void height(Node root, int h) {
        if (sameLevel == false)
            return;
        if (root == null)
            return;
        if (root.left == null && root.right == null) {

            if (leafLevel == -1)
                leafLevel = h;
            else if (leafLevel != h)
                sameLevel = false;
            return;
        }
        height(root.left, h + 1);
        height(root.right, h + 1);
    }
}
