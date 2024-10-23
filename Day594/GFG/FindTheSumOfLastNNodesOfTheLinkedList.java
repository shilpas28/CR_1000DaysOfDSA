//GFG
//Find the Sum of Last N nodes of the Linked List
//Time complexity: O(N)
//Space complexity: O(1)

public class FindTheSumOfLastNNodesOfTheLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(9);
        head.next.next = new Node(6);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(10);
        int n = 3;
        System.out.println(sumOfLastN_Nodes(head, n));
    }

    // Return the sum of last k nodes
    public static int sumOfLastN_Nodes(Node head, int n) {
        // write code here
        Node temp = head;
        int count = 0, sum = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        count -= n;
        temp = head;
        while (temp != null) {
            if (count == 0)
                sum += temp.data;
            else
                count--;
            temp = temp.next;
        }
        return sum;
    }
}
