//GFG
//AVL Tree Insertion
//Time complexity: O(logN)
//Space complexity: O(height of tree)

package GFG;

public class AVLTreeInsertion {

    static class Node {
        int data;
        Node left;
        Node right;
        int height;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) {
        
    }

    public  Node insertToAVL(Node node,int data)
    {
        //code here
        if(node == null){
            return new Node(data);
        }
        if(data < node.data){
            node.left = insertToAVL(node.left, data);
        }else if(data > node.data){
            node.right = insertToAVL(node.right, data);
        }else{
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    static int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    static int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
}
