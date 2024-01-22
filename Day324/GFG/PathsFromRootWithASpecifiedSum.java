//GFG
//Paths from root with a specified sum
//Time complexity: O(N^2)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;

public class PathsFromRootWithASpecifiedSum {

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
        int sum = 8;
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right = new Node(15);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println(printPaths(root, sum));
    }

    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        // code here
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        printPathsUtil(root, sum, 0, path, ans);
        return ans;
    }

    static void printPathsUtil(Node currNode, int sum, int sumSoFar, ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> ans) {
        if (currNode == null) {
            return;
        }
        sumSoFar += currNode.data;
        path.add(currNode.data);
        if (sumSoFar == sum) {
            ans.add(new ArrayList<>(path));
        }
        if (currNode.left != null) {
            printPathsUtil(currNode.left, sum, sumSoFar, path, ans);
        }

        if (currNode.right != null) {
            printPathsUtil(currNode.right, sum, sumSoFar, path, ans);
        }
        path.remove(path.size() - 1);
    }
}
