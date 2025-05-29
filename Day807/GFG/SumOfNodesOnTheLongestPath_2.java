//GFG
//Sum of nodes on the longest path
//Time complexity: O(N)
//Space complexity: O(N)

public class SumOfNodesOnTheLongestPath_2 {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.left.right.left = new Node(6);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        System.out.println(sumOfLongRootToLeafPath(root));
    }

    static int ans = Integer.MIN_VALUE, mxCount = 0;

    public static int sumOfLongRootToLeafPath(Node root) {
        // code here
        int sum = 0, count = 0;
        ans = Integer.MIN_VALUE;
        mxCount = 0;
        help(root, sum, count);
        return ans;
    }

    static void help(Node root, int sum, int count) {
        if (root == null) {
            if (count > mxCount) {
                ans = sum;
                mxCount = count;
            } else if (count == mxCount) {
                ans = Math.max(ans, sum);
            }
            return;
        }
        sum += root.data;
        count++;
        help(root.left, sum, count);
        help(root.right, sum, count);
    }
}
