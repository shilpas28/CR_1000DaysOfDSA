//Leetcode
//3217. Delete Nodes From Linked List Present in Array - Method 2
//Time complexity: O(n+m)
//Space complexity: O(k)

public class DeleteNodesFromLinkedListPresentInArray_2 {

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
        int[] nums = { 1, 2, 3 };
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = modifiedList(nums, head);
        printList(res);
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;
        for (int num : nums) {
            max = num > max ? num : max;
        }

        boolean[] freq = new boolean[max + 1];
        for (int num : nums)
            freq[num] = true;

        ListNode temp = new ListNode();
        ListNode current = temp;
        while (head != null) {
            if (head.val >= freq.length || freq[head.val] == false) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }
        current.next = null;
        return temp.next;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");

            head = head.next;
        }
    }
}
