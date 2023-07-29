//GFG
//Median Of BST - Find kth node Recursively
//Time complexity: O(N)
//Space complexity: O(Height of tree)

package GFG;

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
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println(findMedian(root));
    }

    public static float findMedian(Node root) {
        // code here.
        int n = countNodes(root);
        if (n % 2 != 0) {
            int ans[] = new int[1];
            ans[0] = 0;
            find(root, 1 + n / 2, new int[] { 0 }, ans);
            return (ans[0]);

        } else {
            int ans1[] = new int[1];
            int ans2[] = new int[1];
            find(root, n / 2, new int[] { 0 }, ans1);
            find(root, 1 + n / 2, new int[] { 0 }, ans2);
            return (ans1[0] + ans2[0]) / 2.0f;
        }
    }

    static int countNodes(Node n) {
        // this function returns number of nodes in tree
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    static void find(Node node, int k, int[] count, int arr[]) {
        if (node == null)
            return;
        find(node.left, k, count, arr);
        count[0]++;
        if (count[0] == k) {
            arr[0] = node.data;
            return;
        }
        find(node.right, k, count, arr);
    }
}
