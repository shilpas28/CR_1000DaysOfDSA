//Leetcode
//3217. Delete Nodes From Linked List Present in Array - Method 1
//Time complexity: O(NlogN)
//Space complexity: O(N)

import java.util.Arrays;

public class DeleteNodesFromLinkedListPresentInArray {

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
        int n = nums.length;
        Arrays.sort(nums);
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null) {
            if (fast.val > nums[n - 1]) {
                slow = fast;
                fast = fast.next;
                continue;
            }
            if (help(nums, fast.val)) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        for (int i = 0; i < n; i++) {
            if (head.val == nums[i]) {
                head = head.next;
            }
        }
        return head;
    }

    public static boolean help(int[] nums, int a) {
        int l = 0, h = nums.length - 1, mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;
            if (nums[mid] == a) {
                return true;
            } else if (nums[mid] > a) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
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
