//GFG
//Median of BST 
//Time complexity: O(N)
//Space complexity: O(1)

public class MedianOfBST_2 {

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
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(findMedian(root));
    }

    public static int findMedian(Node root) {
        // Code here
        getLen(root);
        inorder(root);
        return ans;
    }

    static int len = 0;
    static int count = 0;
    static int ans = -1;

    static void getLen(Node root) {
        if (root == null)
            return;

        len++;
        getLen(root.left);
        getLen(root.right);
    }

    static void inorder(Node root) {
        if (root == null || ans != -1)
            return;

        inorder(root.left);
        count++;
        if (len % 2 == 0) {
            if (count == len / 2) {
                ans = root.data;
            }
        } else {
            if (count == ((len + 1) / 2)) {
                ans = root.data;
            }
        }
        inorder(root.right);
    }
}
