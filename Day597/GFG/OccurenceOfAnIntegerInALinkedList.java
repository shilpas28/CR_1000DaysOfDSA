//GFG
//Occurence of an integer in a Linked List
//Time complexity: O(N)
//Space complexity: O(1) 

public class OccurenceOfAnIntegerInALinkedList {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(1);
        int key = 1;
        System.out.println(count(head, key));
    }

    public static int count(Node head, int key) {
        // code here
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.data == key)
                count++;
            temp = temp.next;
        }
        return count;
    }
}
