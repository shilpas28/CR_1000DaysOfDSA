//GFG
//Sort a k sorted doubly linked list
//Time complexity: O(n*logk)
//Space complexity: O(k)

import java.util.PriorityQueue;

public class SortAKSortedDoublyLinkedList {

    static class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        DLLNode head = new DLLNode(3);
        head.next = new DLLNode(2);
        head.next.prev = head;
        head.next.next = new DLLNode(1);
        head.next.next.prev = head.next;
        head.next.next.next = new DLLNode(5);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DLLNode(6);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new DLLNode(4);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        int k = 2;
        DLLNode res = sortAKSortedDLL(head, k);
        printDoublyLinkedList(res);
    }

    public static DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        PriorityQueue<DLLNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        int i = 0;
        while (i <= k && head != null) {
            pq.add(head);
            head = head.next;
            ++i;
        }

        DLLNode newHead = null;
        DLLNode curr = null;
        while (!pq.isEmpty()) {
            if (newHead == null) {
                newHead = pq.poll();
                newHead.next = null;
                newHead.prev = null;
                curr = newHead;
            } else {
                curr.next = pq.poll();
                curr.next.prev = curr;
                curr = curr.next;
            }

            if (head != null) {
                pq.add(head);
                head = head.next;
            }
        }
        curr.next = null;
        return newHead;
    }

    static void printDoublyLinkedList(DLLNode head) {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
