//Leetcode
//143. Reorder List
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ReorderList_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        printList(head);
    }

    public static void reorderList(ListNode head) {
        if (head.next == null)
            return;
        // step 1: find the middle pointer of the linked list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        // step 2: reverse the last half linked list
        ListNode p = mid, q = mid.next, pp = null, qq = null;
        mid.next = null;
        while (q != null) {
            pp = p;
            p = q;
            q = q.next;
            p.next = pp;
        }
        mid = p;
        // step 3: merge first half and reversed last half
        p = head;
        q = mid;
        while (q != null) {
            pp = p;
            qq = q;
            p = p.next;
            q = q.next;
            pp.next = qq;
            qq.next = p;
        }
    }

    public static void printList(ListNode head) {
        ListNode currNode = head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }
}
