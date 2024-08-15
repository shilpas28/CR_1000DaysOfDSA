//GFG
//Add 1 to a Linked List Number
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class Add1ToALinkedListNumber {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(6);
        Node res = addOne(head);
        printList(res);
    }

    public static Node addOne(Node head) {
        // code here.
        Node curr = head, nxt = head.next, prev = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        Node lastHead = prev;
        while (prev != null) {
            if (prev.data != 9) {
                prev.data += 1;
                break;
            } else
                prev.data = 0;
            prev = prev.next;
        }
        if (prev == null)
            head.next = new Node(1);
        curr = lastHead;
        nxt = lastHead.next;
        prev = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
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
