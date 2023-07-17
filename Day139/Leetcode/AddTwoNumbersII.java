//Leetcode
//445. Add Two Numbers II
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.Stack;

public class AddTwoNumbersII {

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
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }

    public static void printList(ListNode list) 
    { 
        ListNode currNode = list; 
        System.out.print("LinkedList: "); 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.val+ " "); 
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int carry = 0;
        ListNode ans = null;
        ListNode newNode;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            sum += carry;
            carry = sum / 10;
            newNode = new ListNode(sum % 10);
            newNode.next = ans;
            ans = newNode;
            sum = 0;
        }
        if (carry != 0) {
            newNode = new ListNode(carry);
            newNode.next = ans;
            ans = newNode;
        }
        return ans;
    }
}
