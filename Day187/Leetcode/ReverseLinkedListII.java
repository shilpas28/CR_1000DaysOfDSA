//Leetcode
//92. Reverse Linked List II
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class ReverseLinkedListII {

    // Definition for singly-linked list.
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
        int left = 2, right = 4;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next = new ListNode(3);
        head.next = new ListNode(4);
        head.next = new ListNode(5);
        ListNode res = reverseBetween(head, left, right);
        printList(res);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        int k = 1;
        while(cur.next != null && k != left){
            cur = cur.next;
            pre = pre.next;
            k++;
        }

        while(cur.next != null && k != right){
            ListNode preNext = pre.next;
            pre.next = cur.next;
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preNext;
            k++;
        }

        return dummy.next;
    }

    // Method to print the LinkedList.
    public static void printList(ListNode list) {
        ListNode currNode = list;
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
