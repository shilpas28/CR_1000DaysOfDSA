//Leetcode
//86. Partition List
//Time complexity: O(N)
//Space complexity: O(1) 

package Extra_Leetcode;

public class PartitionList {
    
    public static class ListNode {
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
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;

        printlist(head);
        partition(head, x);
        printlist(head);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode higher = new ListNode(0);
        ListNode smallerHead = smaller;
        ListNode higherHead = higher;
        
        while (head != null) {
            if (head.val < x) {
                smallerHead.next = head;
                smallerHead = smallerHead.next;
            } else {
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head = head.next;
        }

        higherHead.next = null;
        smallerHead.next = higher.next;
        return smaller.next;
    }

    public static void printlist(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
