//GFG
//Insert in Sorted Circular Linked List
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class InsertInSortedCircularLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int data = 2;
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = head;
        Node res = sortedInsert(head, data);
        printList(res);
    }

    public static Node sortedInsert(Node head, int data) {
        // code here
        Node ans = new Node(data);
        if (head == null) {
            ans.next = ans;
            return ans;
        }
        Node temp = head;
        Node temp2 = null;
        do {
            temp2 = temp;
            temp = temp.next;
            if (data <= temp.data && data >= temp2.data)
                break;
        } while (temp != head);
        temp2.next = ans;
        ans.next = temp;
        if (data < head.data)
            return ans;
        return head;
    }

    static void printList(Node head) {
        Node temp;
        if (head != null) {
            temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }
}
