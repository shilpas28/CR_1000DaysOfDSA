//GFG
//Print leaf nodes from preorder traversal of BST
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class PrintLeafNodesFromPreorderTraversalOfBST {

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
        int[] preorder = { 4, 2, 1, 3, 6, 5 };
        System.out.println(leafNodes(preorder));
    }

    public static ArrayList<Integer> leafNodes(int[] preorder) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int n = preorder.length;

        for (int i = 0; i < n - 1; i++) {
            int curr = preorder[i];
            int next = preorder[i + 1];
            boolean isLeaf = false;

            if (next < curr) {
                // Going left subtree
                stack.push(curr);
            } else {
                // Going right subtree
                while (!stack.isEmpty() && next > stack.peek()) {
                    stack.pop();
                    isLeaf = true;
                }
                if (isLeaf) {
                    // Current is a leaf
                    result.add(curr);
                }
            }
        }
        // Last node is always a leaf
        result.add(preorder[n - 1]);
        return result;
    }
}
