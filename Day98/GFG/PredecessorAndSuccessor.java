//GFG
//Predecessor and Successor
//Time complexity: O(Height of the BST)
//Space complexity: O(Height of the BST)

package GFG;

public class PredecessorAndSuccessor {
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
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(11);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        root.left.right.left.right = new Node(4);
        int key = 8;
        findPreSuc(root, key);
    }

    static Node suc, pre;

    // Function to check whether a Binary Tree is BST or not.
    public static void findPreSuc(Node root, int key) {
        // code here.
        /*
         * There are two static nodes defined above pre(representing predecessor) and
         * suc(representing successor) as follows:
         * static Node pre=null,suc=null
         * You need to update these both.
         * And the data inside these classes will be printed automatically by the driver
         * code.
         */
        Node[] predecessor = { pre };
        Node[] successor = { suc };
        solve(root, predecessor, successor, key);
        pre = predecessor[0];
        suc = successor[0];
        //System.out.println(pre.data +" " + suc.data);
    }

    static void solve(Node root, Node[] predecessor, Node[] successor, int key) {
        if (root == null)
            return;
        if (root.data == key) {
            solve(root.right, predecessor, successor, key);
            solve(root.left, predecessor, successor, key);
        } else if (root.data < key) {
            predecessor[0] = root;
            solve(root.right, predecessor, successor, key);
        } else {
            successor[0] = root;
            solve(root.left, predecessor, successor, key);
        }
    }

}
