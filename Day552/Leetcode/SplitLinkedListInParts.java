//Leetcode
//725. Split Linked List in Parts
//Time complexity: O(N), where N is the number of nodes in the linked list.
//Space complexity: O(K), where k is the number of parts in which the linked list is split.

import java.util.Arrays;

public class SplitLinkedListInParts {

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
        int k = 5;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(Arrays.toString(splitListToParts(head, k)));
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        // Create an array of ListNode pointers to store the k parts.
        ListNode[] parts = new ListNode[k];
        // Calculate the length of the linked list.
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        // Calculate the minimum guaranteed part size (n) and the number of extra nodes
        // (r).
        int n = len / k, r = len % k;
        // Reset the pointer to the beginning of the linked list.
        node = head;
        ListNode prev = null;
        // Loop through each part.
        for (int i = 0; node != null && i < k; i++, r--) {
            // Store the current node as the start of the current part.
            parts[i] = node;
            // Traverse n + 1 nodes if there are remaining extra nodes (r > 0).
            // Otherwise, traverse only n nodes.
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            // Disconnect the current part from the rest of the list by setting prev.next to
            // null.
            if (prev != null) {
                prev.next = null;
            }
        }
        // Return the array of k parts.
        return parts;
    }

}
