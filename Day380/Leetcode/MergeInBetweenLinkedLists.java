//Leetcode
//1669. Merge In Between Linked Lists
//Time complexity: O(n) where n = size(list1) + size(list2)
//Space complexity: O(1)

package Leetcode;

public class MergeInBetweenLinkedLists {

    static public class ListNode {
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
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(13);
        list1.next.next.next = new ListNode(6);
        list1.next.next.next.next = new ListNode(9);
        list1.next.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next.next = null;

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        list2.next.next.next = new ListNode(5);

        int a = 3, b = 4;

        ListNode res = mergeInBetween(list1, a, b, list2);
        printList(res);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode end = list1, start = null;
        for (int i = 0; i < b; ++i, end = end.next) { // locate b upon termination of the loop.
            if (i == a - 1) { // locate the node right before a.
                start = end;
            }
        }
        start.next = list2; // connect the node right before a to the head of list2, hence cut off a from
                            // list1.
        while (list2.next != null) { // traverse till the end of list2.
            list2 = list2.next;
        }
        list2.next = end.next; // connect end of list2 to the node right after b.
        end.next = null; // cut off b from list1.
        return list1;
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
