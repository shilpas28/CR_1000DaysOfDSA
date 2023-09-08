//GFG
//Binary Tree to BST
//Time complexity: O(NLogN)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {

    // Structure of the node class is
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node res = binaryTreeToBST(root);
        printInorder(res);
    }

    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    static int i = 0;
    static Node binaryTreeToBST(Node root)
    {
       // Your code here
       ArrayList<Integer> list = new ArrayList<>();
       getNodes(root,list);
       Collections.sort(list);
       inorder(root,list);
       return root;
       
    }
    
    static void getNodes(Node root, ArrayList<Integer> list){
        if(root==null) return;
        list.add(root.data);
        getNodes(root.left,list);
        getNodes(root.right,list);
    }
    
    static void inorder(Node root, ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        root.data = list.get(i++);
        inorder(root.right,list);
    }

    static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
