//Leetcode
//2807. Insert Greatest Common Divisors in Linked List
//Time complexity: O(n∗log(min(a,b)))
//Space complexity: O(1)

package Leetcode;

public class InsertGreatestCommonDivisorsInLinkedList {

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
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        ListNode res = insertGreatestCommonDivisors(head);
        printList(res);
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curNode = head;
        while (curNode.next != null) {
            int gcd = gcd(curNode.val, curNode.next.val);
            ListNode node = new ListNode(gcd);
            node.next = curNode.next;
            curNode.next = node;
            curNode = curNode.next.next;
        }
        return head;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void printList(ListNode head) {
        ListNode currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}
