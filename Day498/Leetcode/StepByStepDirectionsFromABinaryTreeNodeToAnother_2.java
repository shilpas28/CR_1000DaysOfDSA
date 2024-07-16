//Leetcode
//2096. Step-By-Step Directions From a Binary Tree Node to Another - LCA Understanding And Path Cutting
//Time complexity: O(n), this is still O(n) since we traverse through whole binary tree but this approach is faster in real-world 
//situations due to the smaller coef in front of n
//Space complexity: O(n), since we use two arrays to store the path

import java.util.ArrayList;
import java.util.List;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother_2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int startValue = 3, destValue = 6;
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(getDirections(root, startValue, destValue));
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> pathToStart = new ArrayList<>();
        List<String> pathToDestination = new ArrayList<>();
        findPathFromRoot(root, startValue, pathToStart);
        findPathFromRoot(root, destValue, pathToDestination);

        int commonPathLen = 0;
        while (commonPathLen < pathToStart.size() && commonPathLen < pathToDestination.size() &&
                pathToStart.get(commonPathLen).equals(pathToDestination.get(commonPathLen))) {
            commonPathLen++;
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < pathToStart.size() - commonPathLen; i++) {
            res.add("U");
        }
        res.addAll(pathToDestination.subList(commonPathLen, pathToDestination.size()));
        return String.join("", res);
    }

    static boolean findPathFromRoot(TreeNode curNode, int targetValue, List<String> pathToAppend) {
        if (curNode == null)
            return false;
        if (curNode.val == targetValue)
            return true;

        pathToAppend.add("R");
        if (findPathFromRoot(curNode.right, targetValue, pathToAppend))
            return true;

        pathToAppend.remove(pathToAppend.size() - 1);
        pathToAppend.add("L");
        if (findPathFromRoot(curNode.left, targetValue, pathToAppend))
            return true;

        pathToAppend.remove(pathToAppend.size() - 1);
        return false;
    }
}
