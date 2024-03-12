//Leetcode
//1171. Remove Zero Sum Consecutive Nodes from Linked List - Recursive
//Time complexity: O(N^2)
//Space complexity: O(N)

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

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
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        ListNode res = removeZeroSumSublists(head);
        printList(res);
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int sum = 0;
        while (cur != null) {
            if (cur.val + sum == 0)
                dummy.next = cur.next;
            sum += cur.val;
            cur = cur.next;
        }
        if (dummy.next != null)
            dummy.next.next = removeZeroSumSublists(dummy.next.next);
        return dummy.next;
    }

    static void printList(ListNode head) {
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
