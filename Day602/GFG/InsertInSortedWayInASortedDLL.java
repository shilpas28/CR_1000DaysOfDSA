//GFG
//Insert in Sorted way in a Sorted DLL
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class InsertInSortedWayInASortedDLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(12);
        int x = 9;
        Node res = sortedInsert(head, x);
        printList(res);
    }

    public static Node sortedInsert(Node head, int x) {
        // add your code here
        Node temp = new Node(x);
        temp.next = null;
        temp.prev = null;

        if (head.data > x) {
            temp.next = head;
            head.prev = temp;
            head = temp;
            return head;
        }

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data > temp.data)
                break;
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            prev.next = temp;
            temp.prev = prev;
        } else {
            prev.next = temp;
            temp.prev = prev;
            temp.next = curr;
            curr.prev = temp;
        }

        return head;
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
