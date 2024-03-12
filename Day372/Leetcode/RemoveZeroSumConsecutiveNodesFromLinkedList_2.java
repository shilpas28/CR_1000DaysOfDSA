//Leetcode
//1171. Remove Zero Sum Consecutive Nodes from Linked List - Iterative
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesFromLinkedList_2 {

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
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                cur = map.get(sum).next;
                int key = sum + cur.val;
                while (key != sum) {
                    map.remove(key);
                    cur = cur.next;
                    key += cur.val;
                }
                map.get(sum).next = cur.next;
            } else {
                map.put(sum, cur);
            }
            cur = cur.next;
        }
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
