//GFG
//Remove all occurences of duplicates in a linked list
//Time complexity: O(N)
//Space complexity: O(1)

public class RemoveAllOccurencesOfDuplicatesInALinkedList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(23);
        head.next = new Node(28);
        head.next.next = new Node(28);
        head.next.next.next = new Node(35);
        head.next.next.next.next = new Node(49);
        head.next.next.next.next.next = new Node(49);
        head.next.next.next.next.next.next = new Node(53);
        head.next.next.next.next.next.next.next = new Node(53);
        head = removeAllDuplicates(head);
        printList(head);
    }

    public static Node removeAllDuplicates(Node head) {
        // code here
        if (head.next == null)
            return head;
        Node ans = new Node(-1), prev = head;
        Node temp = ans;
        head = head.next;
        int count = 1;
        while (head != null) {
            if (prev.data == head.data)
                count++;
            else if (count == 1) {
                temp.next = prev;
                temp = temp.next;
            } else
                count = 1;
            prev = head;
            head = head.next;
        }
        if (count == 1)
            temp.next = prev;
        else
            temp.next = null;
        return ans.next;
    }

    static void printList(Node head) {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
}
