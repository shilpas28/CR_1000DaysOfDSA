//GFG
//Construct Tree from Preorder & Postorder
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderAndPostorder {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
        Node res = constructTree(pre, post);
        printInorder(res);
    }

    static Map<Integer, Integer> postOrderMap;

    public static Node constructTree(int[] pre, int[] post) {
        // code here
        if (pre == null || pre.length == 0) {
            return null;
        }

        postOrderMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postOrderMap.put(post[i], i);
        }
        return build(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    static Node build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {

        if (preStart > preEnd) {
            return null;
        }
        Node root = new Node(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int leftSubVal = pre[preStart + 1];
        int postIndex = postOrderMap.get(leftSubVal);
        int leftSubtreeSize = postIndex - postStart + 1;
        root.left = build(pre, preStart + 1, preStart + leftSubtreeSize,
                post, postStart, postIndex);
        root.right = build(pre, preStart + leftSubtreeSize + 1, preEnd,
                post, postIndex + 1, postEnd - 1);

        return root;
    }

    static void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
