//GFG
//Construct Tree from Inorder & Preorder
//Time complexity: O(N^2)
//Space complexity: O(N)

public class ConstructTreeFromInorderAndPreorder {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int inorder[] = { 3, 1, 4, 0, 2, 5 };
        int preorder[] = { 0, 1, 3, 4, 2, 5 };
        Node res = buildTree(inorder, preorder);
        printInorder(res);
    }

    static int pos;
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        pos = 0;
        return solve(inorder, preorder, 0, inorder.length-1);
    }

    static Node solve(int inorder[], int preorder[], int str, int end){
        if(str>inorder.length || str> end){
            return null;
        }
        Node root = new Node(preorder[pos]);
        int div = 0;
        for(int i=str;i<=end;i++){
            if(preorder[pos] == inorder[i]){
                div = i;
                break;
            }
        }
        pos++;
        root.left = solve(inorder, preorder, str, div-1);
        root.right = solve(inorder, preorder, div+1, end);
        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
