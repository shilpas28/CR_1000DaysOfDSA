//GFG
//Multiply two linked lists
//Time complexity: O(max(n,m))
//Space complexity: O(1)

public class MultiplyTwoLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(3);
        first.next = new Node(2);
        Node second = new Node(2);
        System.out.println(multiplyTwoLists(first, second));
    }

    public static long multiplyTwoLists(Node first, Node second) {
        // Code here
        long num1 = listToNum(first);
        long num2 = listToNum(second);
        return (num1 * num2) % 1000000007;
    }

    public static long listToNum(Node node) {
        long num = 0, mod = 1000000007;
        while (node != null) {
            num = (num * 10 + node.data) % mod;
            node = node.next;
        }
        return num;
    }
}
