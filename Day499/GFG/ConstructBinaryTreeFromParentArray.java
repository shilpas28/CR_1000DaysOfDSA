//GFG
//Construct Binary Tree from Parent Array
//Time complexity: O(n)
//Space complexity: O(n)

public class ConstructBinaryTreeFromParentArray {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int parent[] = { -1, 0, 0, 1, 1, 3, 5 };
        Node res = createTree(parent);
        printInorder(res);
    }

    // Function to construct binary tree from parent array.
    public static Node createTree(int parent[]) {
        // Your code here
        int n = parent.length;
        Node temp[] = new Node[n];
        for (int i = 0; i < n; i++) {
            temp[i] = new Node(i);
        }
        Node head = null;
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                if (temp[parent[i]].left == null)
                    temp[parent[i]].left = temp[i];
                else
                    temp[parent[i]].right = temp[i];
            } else
                head = temp[i];
        }
        return head;
    }

    static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
