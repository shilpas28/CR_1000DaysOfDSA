//GFG
//Median of BST 
//Time complexity: O(N)
//Space complexity: O(1)

public class MedianOfBST_3 {

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

    static int ans;

    public static int findMedian(Node root) {
        // Code here
        int[] count = { 0 };
        countNodes(root, count);
        int n = count[0];
        count[0] = (n + (n % 2)) / 2;
        ans = 0;
        getMedian(root, count);
        return ans;
    }

    static void countNodes(Node root, int[] count) {
        if (root == null)
            return;
        countNodes(root.left, count);
        count[0]++;
        countNodes(root.right, count);
    }

    static void getMedian(Node root, int[] count) {
        if (root == null)
            return;
        getMedian(root.left, count);
        count[0]--;
        if (count[0] == 0) {
            ans = root.data;
            return;
        }
        getMedian(root.right, count);
    }
}
