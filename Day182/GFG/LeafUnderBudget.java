//GFG
//Leaf Under Budget
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.LinkedList;
import java.util.Queue;

public class LeafUnderBudget {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(3);
        root.right.right = new Node(6);
        root.right.left.right = new Node(8);
        int budget = 8;
        System.out.println(getCount(root, budget));
    }

    static class Pair {
        Node a;
        int b;

        Pair(Node a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static int getCount(Node node, int bud) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 1));
        int count = 0;
        int sum = 0;

        while (q.size() > 0) {
            Node temp = q.peek().a;
            int lvl = q.peek().b;
            q.remove();
            if (temp.left == null && temp.right == null) {
                count++;
                sum = sum + lvl;
                if (sum > bud)
                    return count - 1;
                if (sum == bud)
                    return count;
            }
            if (temp.left != null)
                q.add(new Pair(temp.left, lvl + 1));
            if (temp.right != null)
                q.add(new Pair(temp.right, lvl + 1));
        }
        return count;
    }
}
