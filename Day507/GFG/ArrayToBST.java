//GFG
//Array to BST
//Time complexity: O(n)
//Space complexity: O(n)

public class ArrayToBST {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Node res = sortedArrayToBST(nums);
        printInorder(res);
    }

    public static Node sortedArrayToBST(int[] nums) {
        // Code here
        return build(nums, 0, nums.length - 1);
    }

    static Node build(int a[], int l, int r) {
        if (l > r)
            return null;

        int mid = l + (r - l) / 2;
        Node node = new Node(a[mid]);

        node.left = build(a, l, mid - 1);
        node.right = build(a, mid + 1, r);

        return node;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
